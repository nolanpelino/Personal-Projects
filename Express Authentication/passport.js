const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const bcrypt = require("bcrypt");
const helper = require("../helpers/helper");

// Passport strategy
passport.use(new LocalStrategy(
  function (username, password, cb) {
    helper.findByUsername(username, async function (err, user) {
      const matchedPassword = bcrypt.compare(password, user.password);
      if(err) return done(err);
      if(!user) return done(null, false);
      if(!matchedPassword) return done(null, false);
      return (null, user);

    });
  }
));

// Serialize a user
passport.serializeUser((user, done) => {
  done(null, user.id);
});


// Deserialize a user
passport.deserializeUser((id, done) => {
  db.users.findById(id, function (err, user) {
    if(err)
      return done(err);
    return done(null, user);
  })
});