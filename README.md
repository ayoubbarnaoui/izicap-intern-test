# Izicap Homework | Backend Engineering - Internship

## How to run

You have to build the project manually with maven and then build the image with docker.
Run the container and make sure to bind the correct port to your network when running.

## Architecture

This microservice was built using the MVC architecture which has two services: ChatGPTService and CSVService.
The first service is responsible for taking the question from the incoming request and sending a POST request to ChatGPT
API in order to pickup the answer from the response.
The second service is handling saving the question and it's corresponding answer in an CSV file.
One controller is used called ChatGPTController and consuming those services and responding to the user with the
question and the answer.

## Testing

I wrote two unit tests, one for testing the functionality of the querying the ChatGPT API and getting the write answer
to a question.
The other test is for testing writing to the CSV file.

## Issues

I have encountered an issue when trying to consume the api via the docker container.
When using the bridged network mode in the container and sending a POST request to the endpoint I get an error
saying `no protocole 'https://api.openai.com/v1/completions'`.
After some research on the web I tried to use the host network mode but It didn't work and I can't even reach the
server.
I had some issues also when trying to build the docker image as it fails while downloading dependencies, I tried with
so many Dockerfile examples with no luck and I ran out of time and I made a Dockerfile that copies the manual .jar file
built and use it.
I hope you will take that into consideration :)

## About me

My name is AYOUB BARNAOUI, I am a Masters student in Networks and Computer Systems at the Faculty of Science and
Technology in Settat.
I'm a full stack developer mainly with the MERN stack, I have experience with spring boot, Laravel and Angular too.
I'm very passionate with this field and I can learn quickly any technology with passion and determination.