module.exports = function(app) {
   app.use((req,res,next)=>{
console.log('req.user', req.user);
      if(req.user || req.path == '/login' || req.path == '/auth') {
         next();
      } else {
         res.redirect("/login");
      }
    });

    app.get('/login',function(req,res){
       res.render('index.html')
    });

    app.get('/register',function(req,res){
       res.render('class/register.html');
    });
}
