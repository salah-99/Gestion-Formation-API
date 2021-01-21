const mysql = require('mysql');
const path = require('path');
const ejs = require('ejs');
const bodyparser = require('body-parser');
const express = require('express');
var app = express();


app.use(bodyparser.json());
app.set('views',path.join(__dirname,'views'));
app.set('view engine', 'ejs');
app.use(bodyparser.urlencoded({extended: false}));


var  connection = mysql.createConnection({
    host :'localhost',
    user :'root',
    password :'',
    database :'gestionformations_1'
});

connection.connect(function(error){
    if(!error) console.log('database connected!');
    else console.log(error);
});

app.get('/',(req,res)=>{
    let sql = "SELECT *FROM formation";
    let query = connection.query(sql, (err, rows) => {
        if(err) throw err;
        res.render('formation', {
            title : 'Formation',
            user : rows
        });
    });
})

app.get('/session/:id',(req,res)=>{
    const id = req.params.id;
    let sql = "SELECT session.id_s, session.code, session.libellé, formation.id_f FROM session INNER JOIN formation ON session.id_f = formation.id_f AND session.id_f = '" +id+ "' ";
    let query = connection.query(sql, (err, rows) => {
        if(err) throw err;
        res.render('session', {
            title : 'Session',
            user : rows
        });
    });
})

app.listen(3000,()=>console.log('Express server is runing'));

