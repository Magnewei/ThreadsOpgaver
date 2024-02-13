# Exercises wednesday/thursday
Exercises for thursday is to reprogram our web server from last week so that it becomes more responsive (more quickly
becomes ready for next request).

## Exercise 1.
Based on the RequestDataServer from last weeks demo code (network and sockets) we make small changes to run each server
response in a new thread. You need an ExecutorService that you insert just before the while loop (the one called
workingJack in the example below). After the while loop comes Socket socket = server.accept(); which is a blocking call
that waits for a new request from a client/browser.

Then we take all the code from the try-catch block and move it into a separate method (HINT: Refactor -> Extract ->
Method: Give the method a name. Below we have called it MakeResponse). Now we only have a single method call under the
line that creates a socket. This line can now be inserted into a run method inside an anonymous implementation of the
interface: Runnable like this:

```java

Socket socket = server.accept();
workingJack.submit(new Runnable() {
    @Override
      public void run() {
        try {
            MakeResponse(socket, root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
        }
    });
```
In this way all responses that the server needs to make will be put out in another thread, so that the main thread will
be ready to wait for a new request from a browser as soon as possible.

## Exercise 2.
Now look at the RequestFileServer from last weeks demo code. Make changes to the code so that there
will be a task and executor that returns files - a bit like the previous exercise.

## Exercise 3.
Building on the previous exercise, try to make changes so that the generateRequestObject() method is run in a separate
thread.
## Exercise 4.
Make changes to RequestDataClient so that it can send multiple requests to the server. The requests should be sent in
separate threads.
Make a Junit test that tests that the server can handle multiple requests at the same time.