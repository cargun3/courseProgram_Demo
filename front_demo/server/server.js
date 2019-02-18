var express = require('express');
var session = require('express-session');
var app = express();
var bodyParser = require('body-parser');
var request = require('request');


let port = 3000;
app.use('/', express.static(__dirname + '/../build'));

app.set('views', __dirname + '/../public/views');

app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

app.use(bodyParser.urlencoded({extended: false}));

app.use(session({
 secret: '@#@$MYSIGN#@$#$',
 resave: false,
 saveUninitialized: true
}));

var passport = require('./lib/passport')(app);


var indexRouter = require('./routes/index')(app);
var courseRouter = require('./routes/course');
var authRouter = require('./routes/auth')(passport);


app.use('/', indexRouter);
app.use('/course', courseRouter);
app.use('/auth', authRouter);

app.use(function(req, res, next) {
  res.status(404).render('error/404.html');
});

app.use(function (err, req, res, next) {
  res.status(500).render('error/500.html')
});



const server = app.listen(port, () => {
    console.log('Express listening on port', port);
});
