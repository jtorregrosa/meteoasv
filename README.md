<div id="top"></div>

## About The Project

The company "Grupo ASV" asked me to perform a technical test to ensure the required knowledge
about the technology stack is adquired.

### CASE STUDY

They have asked us for a web application to check the weather forecast at any
municipality of Spain. After studying the different ways to obtain this information,
has determined that it would be best to retrieve it via the AEMET API. For this we must:
1. Request an API Key from https://opendata.aemet.es/centrodedescargas/inicio.
2. Review the API documentation and find the necessary methods to retrieve the API
Next information. Specifically, we will have to locate the following services:
- Retrieve a list with all the municipalities in Spain
- Retrieve the specific prediction for a municipality

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

You will need to install docker in order to be able to execute and test the application.
Moreover, docker-compose extension is required too.

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://opendata.aemet.es/centrodedescargas/inicio](https://opendata.aemet.es/centrodedescargas/inicio)

2. Clone the repository.

  ```sh
  $ git clone https://github.com/jtorregrosa/meteoasv.git
  ```

3. Enter your APIKEY in the file `deploy/environments/meteoasv-api.env`

  ```env
  APPLICATION_AEMET_APIKEY=YOUR_AEMET_API_KEY
  ```

4. Run and evaluate this test with mercy =)

  ```sh
  $ docker compose -f deploy/docker-compose.yml up
  ```

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.md` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Jorge Torregrosa Lloret - jtorregrosalloret@gmail.com

<p align="right">(<a href="#top">back to top</a>)</p>