const express = require("express");

const app = express();

app.get("/", (req, res) => {
	res.sendFile(`${__dirname}/html/index.html`)
});

app.get("/contato", (req, res) => {
	res.send("Página de contato");
});

app.get("/produtos/:item", (req, res) => {
	res.send(`Item: ${req.params.item}`);
});

app.get("/produtos/:item/:qtn", (req, res) => {
	res.send(`Item: ${req.params.item} tem ${req.params.qtn} unidades.`);
});

app.listen(8081, () => {
	console.log("Servidor rodando na porta 8081");
});

/*
    Anotações:
    Foi instalado o nodemon para a atualização automática do server
*/