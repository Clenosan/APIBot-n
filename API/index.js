'use strict'

var express = require('express');

var app = express();

var api = express.Router();

// controller
    //Req --> request
    //res --> response
const showHelloWolrd = (req, res) =>
{
    res.status(200).send({
        message: 'Sube el volumen.'
    });
};

// Routues
api.get('/hello-world', showHelloWolrd);

// Base Route
app.use('/api', api);

// boot server
var port = 41000;
app.listen(port, () =>
{
    console.log("Listening on http://localhost:" + port); 
});