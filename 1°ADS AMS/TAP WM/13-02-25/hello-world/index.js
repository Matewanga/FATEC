const http = require("http")

http.createServer(function(req, resp, ){
  resp.end("Mensagem direcionada")
}).listen(8081)

console.log("Servidor ativo");