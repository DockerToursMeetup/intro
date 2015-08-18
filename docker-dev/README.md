# Build

```
docker build -t awesome-dev .
```

# Run

```
docker run -it --rm                  # run in interactive mode
     -v %{jarPath}:/workdir/myapp.jar   # mount host jar into the container
     -v %{confPath}:/workdir/myconf.yml # mount host conf into the container
     -p 8080:8080                       # bind to host api port
     -p 8081:8081                       # bind to host healthcheck port
      awesome-dev
```
