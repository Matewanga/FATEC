const express = require("express");
const Handlebars = require("handlebars");
const app = express();
const handlebars = require("express-handlebars").engine;
const bodyParser = require("body-parser");
const post = require("./models/post");
const { where } = require("sequelize");
const e = require("express");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

Handlebars.registerHelper("eq", (origem, valor) => {
  return origem == valor;
});

app.engine("handlebars", handlebars({ defaultLayout: "main" }));
app.set("view engine", "handlebars");

app.get("/", function (req, res) {
  res.render("primeira_pagina");
});

app.get("/consulta", function (req, res) {
  post
    .findAll()
    .then(function (post) {
      res.render("consulta", { post });
    })
    .catch(function (erro) {
      console.log("Erro ao carregar dados do banco: " + erro);
    });
});

app.post("/cadastrar", function (req, res) {
  console.log(req.body);

  post
    .create({
      nome: req.body.nome,
      telefone: req.body.telefone,
      origem: req.body.origem,
      data_contato: req.body.data_contato,
      observacao: req.body.observacao,
    })
    .then(function () {
      res.redirect("/consulta");
    })
    .catch(function (erro) {
      res.send("Falha ao cadastrar os dados: " + erro);
    });
});

app.get("/atualizar/:id", (req, res) => {
  post
    .findAll({
      where: {
        id: req.params.id,
      },
    })
    .then((post) => {
      res.render("editar_pagina", { post });
    })
    .catch((error) => {
      console.log("Erro ao atualizar post");
    });
});

app.post("/editar/:id", (req, res) => {
  post
    .update(
      {
        nome: req.body.nome,
        telefone: req.body.telefone,
        origem: req.body.origem,
        data_contato: req.body.data_contato,
        observacao: req.body.observacao,
      },
      {
        where: {
          id: req.params.id,
        },
      }
    )
    .then(() => {
      res.redirect("/consulta");
    })
    .catch((error) => {
      console.log(`Erro ao atualizar post: ${error}`);
    });
});

app.get("/deletar/:id", (req, res) => {
  post
    .destroy({
      where: {
        id: req.params.id,
      },
    })
    .then(() => {
      res.redirect("/consulta");
    })
    .catch((error) => {
      res.send("Erro");
    });
});

app.listen(8081, function () {
  console.log("Servidor ativo!");
});
