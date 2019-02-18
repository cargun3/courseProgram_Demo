var API_Call = require('./api')('/auth');

module.exports = function(app) {

  var authData = {
    email: '22@22',
    password: '1',
    nickname: 'egoing'
  };


var passport = require('passport'),
  LocalStrategy = require('passport-local').Strategy;

app.use(passport.initialize());
app.use(passport.session());

passport.serializeUser(function(token, done) {
  done(null, token);
});

passport.deserializeUser(function(token, done) {
  API_Call.isLogin(token, function (err, result) {
     done(err, result.response);
  });
});

passport.use(new LocalStrategy(
  {
    usernameField: 'id',
    passwordField: 'passwords'
  },
  function (username, password, done) {
    API_Call.login(username, password, function (err, result) {
	if(err) {
	   return done(null, false, {
                message: 'login fail.'
           });
	} else {
           return done(null, result.response);
	}
    });
  }
));

return passport;
}
