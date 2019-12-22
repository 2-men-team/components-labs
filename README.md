# components-labs

## Kubernetes setup
- install minikube, kubectl
- `cd <project-dir>/1-lab/`
- `eval $(minikube docker-env)`
- `docker build -t main-service .`
- `minikube start --memory='5000Mb'`
- `kubectl apply -f booking.yaml`
- `minikube service booking --url`
- use url to access apis
