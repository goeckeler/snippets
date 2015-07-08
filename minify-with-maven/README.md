How to minify javascript and css file using maven plugin
===============================

Sample application which shows how to minify javascript and css files using [maven plugin](http://samaxes.github.io/minify-maven-plugin/project-info.html).

See [https://github.com/elitejavacoder/maven-minify-javascript-and-css](https://github.com/elitejavacoder/maven-minify-javascript-and-css) for original version using distinct files. This application uses embeded jetty server so use the following commands to build and run application.

To build application:
---------------------
mvn clean install

To run jetty server:
--------------------
mvn jetty:run

Hit following urls from browser to check minified javascript and css files.

[http://127.0.0.1:8080/scripts/scripts.js](http://127.0.0.1:8080/scripts/scripts.js)
[http://127.0.0.1:8080/styles/styles.css](http://127.0.0.1:8080/styles/styles.css)

Use the following url which returns index page so you can confirm that javascript and css files are functioning properly:

http://127.0.0.1:8080/index.jsp
