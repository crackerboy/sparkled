# Sparkled
[![Build Status](https://travis-ci.org/sparkled/sparkled.svg?branch=master)](https://travis-ci.org/sparkled/sparkled)

Sparkled is a web-based LED sequencer that aims to reduce the barrier to entry for lighting projects.
![Sparkled](https://github.com/sparkled/sparkled/raw/gh-pages/images/sparkled-screenshot.jpg "Sparkled")

## Features
With Sparkled, you get an integrated solution containing:
 * A rich web interface for staging, sequencing, previewing and scheduling music-backed LED animations
 * A fast UDP service to stream rendered pixel data to Sparkled clients, which use the data to drive LED strips (or whatever you want!)

## Clients
Sparkled clients are responsible for rendered pixel data from the Sparkled server and displaying it on the LED strips. The official Sparkled clients are listed below:

- [sparkled-client-esp32](https://github.com/sparkled/sparkled-client-esp32)

## Roadmap
### Before Initial Release
- [x] Move project to Sparkled github account
- [ ] Set up official project website
- [x] Rewrite UI in React (In Progress)
- [x] Stage editor, so users can set up their own lighting structures
- [ ] Lots of unit & integration testing
- [ ] Various bugfixes

### After Initial Release
- [ ] Add more effect and fill types
- [ ] Multithreaded rendering
- [ ] Support sequences without music (currently requires a mute MP3 file to be uploaded)
- [ ] Ability to replace MP3 files for existing sequences (even with different lengths)
- [ ] More Sparkled Clients (ESP8266, Arduino Ethernet)

## Getting Started
Sparkled is currently in pre-alpha, so significant chunks of core functionality are still missing or incomplete.

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites
The following software and hardware requirements must be met before installing the Sparkled server:
* Java SE 8 JDK (8u151 or later recommended)
* Maven 3 (3.5.2 or later recommended)
* A modern web browser (Chrome 60 or later recommended)
* Internet connectivity to download Maven and NPM artifacts

### Installing
[Fork](https://help.github.com/articles/fork-a-repo) and clone the repository
```
SSH:
git clone git@github.com:<your_username>/sparkled.git

HTTPS:
git clone https://github.com/<your_username>/sparkled.git
```

Build the project

**Note:** the initial build will take quite a while, as all of the Maven and NPM dependencies need to be downloaded
```
cd sparkled
mvn install
```

Run Sparkled
```
cd sparkled/app/target
java -jar sparkled.jar
```

Wait for the application to start, then connect to the UI in Chrome via the following URL:
```
http://localhost:8080
```

## Running the tests
Use `maven` to run both the frontend and backend unit tests:
```
cd sparkled
mvn test
```

Use `npm` to run just the frontend unit tests:
```
cd sparkled/webui
npm run test
```

## Built With
* [Java](https://java.com)
* [Maven](https://maven.apache.org)
* [H2](https://www.h2database.com)
* [HikariCP](https://github.com/brettwooldridge/HikariCP)
* [Hibernate](https://hibernate.org)
* [React.js](https://reactjs.org)
* [Bootstrap](https://getbootstrap.com)
* [Wavesurfer.js](https://wavesurfer-js.org)

## Contributing
Please read [CONTRIBUTING.md](#todo:add-contributing) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/sparkled/sparkled/tags). 

## Authors
* **Chris Parton** - [chrisparton1991](https://github.com/chrisparton1991)

See also the list of [contributors](https://github.com/sparkled/sparkled/contributors) who participated in this project.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments
* [FastLED](http://fastled.io) for building and maintaining an incredible LED strip library, without which this project would never have been conceived.
* [The FastLED community](https://plus.google.com/communities/109127054924227823508) for being a great source of help and inspiration.
