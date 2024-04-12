<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./style.css">
    <title>Document</title>
  </head>
  <body>
   
      <div className="wrapper">
        <form action="">
          <h1>Employee Login</h1>
          <div className="input-box">
            <input
              type="text"
              placeholder="Username or Email"
              name="username"
              required
            />
            <FaUser className="icon" />
          </div>
          <div className="input-box">
            <input
              type="password"
              placeholder="Password"
              name="password"
              required
            />
            <FaLock className="icon" />
          </div>
          <div className="remember-forgot">
            <label>
              <input type="checkbox" />
              remember me
            </label>
            <a onClick="{forgotPassword}">Forgot password?</a>
          </div>
          <button>Login</button>
        </form>
        <form className="login-form">
          <h2>OTP Verification</h2>
          <input type="text" name="otp" placeholder="000000" ref="{otp}" />
          <button type="submit">Login</button>
        </form>
      </div>
    
  </body>
</html>
