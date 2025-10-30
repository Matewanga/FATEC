    const Sequelize = require("sequelize");
    const sequelize = new Sequelize("exemplo", "root", "", {
        host: "localhost",
        dialect: "mysql",
    });

    sequelize
        .authenticate()
        .then(function () {
            console.log("Banco funcionando");
        })
        .catch(function (error) {
            console.log(`Falha ao se conectar: ${error}`);
        });

    const Agendamentos = sequelize.define("agendamentos", {
        nome: {
            type: Sequelize.STRING,
        },
        email: {
            type: Sequelize.STRING,
        },
        telefone: {
            type: Sequelize.STRING,
        },
        cpf: {
            type: Sequelize.STRING,
        },
        data: {
            type: Sequelize.STRING,
        },
        hora: {
            type: Sequelize.STRING,
        },
    });

    //Agendamentos.sync({ force: true });
    Agendamentos.create({
        nome: "Nickolas",
        email: "nickolas@gmail.com",
        telefone: "9457-4060",
        cpf: "13246798",
        data: "27-02-25",
        hora: "20:30",
    });
