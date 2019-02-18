var express = require('express');
var router = express.Router();
var path = require('path');
var fs = require('fs');

module.exports = function (passport) {
   router.post('/login',
    passport.authenticate('local', {
      successRedirect: '/course/main',
      failureRedirect: '/login'
   }));

  router.get('/logout', function (request, response) {
    request.logout();
    request.session.save(function () {
      response.redirect('/login');
    });
  });

  return router;
}
