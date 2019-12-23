# components-labs

## Kubernetes setup
- install minikube, kubectl, redis, maven
- in `/etc/redis/redis.conf` comment out `bind 127.0.0.1`
- in that same file set `protected-mode no` and `supervised systemd`
- `sudo systemctl restart redis`
- `cd <project-dir>/1-lab/`
- `mvn package`
- `eval $(minikube docker-env)`
- `docker build -t main-service .`
- `minikube start --memory='5000Mb'`
- `kubectl apply -f booking.yaml`
- `minikube service booking --url`
- use url to access apis

to shutdown:
- `kubectl delete -f booking.yaml`
- `minikube stop`
