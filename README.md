# Service-mesh-on-Kubernetes-with-Istio-and-Spring-Boot

## Environment

1. minikube v1.28.0 on Ubuntu 20.04 (vbox/amd64)

## Service Mesh with Istio on Kubernetes step by step

### Step 1. Installing Istio on Minikube platform

```shell
    $ minikube start --driver=docker --kubernetes-version=v1.23.8
```

### Step 2. install istioctl

```shell
    $ istioctl install
```

### Step 3. Set namespace label

```shell
    $ kubectl label namespace default istio-injection=enabled 
```

### Step 4. Set minikube kubernetes environment

```shell
    $ eval $(minikube -p minikube docker-env)
```

### Step 5. Deployment application yaml

### Step 6. Access your service through port-forward

```shell
    # approach 1. port-forward
    $ kubectl port-forward service/inventory-service 80:80
    
    # approach 2. expose by nodePort
    $ kubectl expose deployment inventory-service --type=NodePort --port=80 --target-port=9020 --name=inventory-nodeport
    
    # approach 3. expose by loadBalancer
    $ kubectl expose deployment inventory-service --type=LoadBalancer --port=80 --target-port=9020 --name=inventory-loadbalancer
```

## Set up Ingress on Minikube with the NGINX Ingress Controller

### Step 1. Enable the NGINX Ingress controller

```shell
    $ minikube addons enable ingress
```

### Step 2. Create an Ingress

```yaml
apiVersion: networking.k8s.io/v1

kind: Ingress

metadata:

  name: inventory-ingress

  annotations:

    nginx.ingress.kubernetes.io/rewrite-target: /$1

spec:

  rules:

    - host: inventory.com

      http:

        paths:

          - path: /

            pathType: Prefix

            backend:

              service:

                name: inventory-service

                port:

                  number: 80
```

### Step 3. Verify the IP address is set

```shell
    $ kubectl get ingress
```

### Step 4. Add ingress ip address and hosts to /etc/hosts

```text
    172.17.0.15 inventory.com
```