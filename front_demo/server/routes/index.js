var express = require('express');
var router = express.Router();
var auth = require('../lib/auth');

module.exports = function (app) {

router.get('/',auth.isLoggedIn,function (req, res) {
  res.redirect('/course/main');
});

router.get('/login',function(req,res){
  if(req.isAuthenticated()) {
    res.redirect('/course/main');
  } else {
    res.render('index.html');
  }
});

return router;

}
