function fn() {
  var env = karate.env;
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    AppUrl: '/api/catalog'
  }
  if (env == 'dev') {
    config.AppUrl = 'http://127.0.0.1:8090' + config.AppUrl
  } else if (env == 'e2e') {
    config.AppUrl = 'http://127.0.0.1:8090' + config.AppUrl
  }
  return config;
}