const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Hello, World!");
});

app.listen(8081, function () {
  console.log("Server running http://localhost:8081");
});
