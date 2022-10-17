# csrfnosession
Spring Security CSRF NO Session Cookie Bug


Steps to Reproduce

1. Checkout the code
2. Build and starat the app.
3. Vist the following url: http://localhost:8080/login
4. Notice that no SESSION cookie is set on the response.

<img width="476" alt="image" src="https://user-images.githubusercontent.com/1258134/196252792-d13befb8-e9c1-4705-a04d-8e4e96977d46.png">
