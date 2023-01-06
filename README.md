# Service-mesh-on-Kubernetes-with-Istio-and-Spring-Boot

## Environment

1. minikube v1.28.0 on Ubuntu 20.04 (vbox/amd64)

## [Service Mesh with Istio on Kubernetes in 5 steps](https://piotrminkowski.com/2018/04/13/service-mesh-with-istio-on-kubernetes-in-5-steps/)

### Step 1. Installing Istio on Minikube platform

```
    $ minikube start --driver=docker --kubernetes-version=v1.23.8
```

### Step 2. install istioctl

```
    $ istioctl install
```

### Step 3. Set namespace label

```
    $ kubectl label namespace default istio-injection=enabled 
```

### Step 4. Set minikube kubernetes environment

```
    $ eval $(minikube -p minikube docker-env)
```

### Step 5. Deployment application yaml