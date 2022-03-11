#Attendees Deployment Workshop

## Overview

This repository contains the code base for a very basic attendees API which models a get request in 2 ways:

* On port 8080 as a REST over HTTP service
* On port 9090 as a gRPC service

There is also [a version 2 branch](https://github.com/jpgough/attendees/tree/v2) containing backwards compatible changes to v1 (not semvar).

The two builds are provided as docker images for easy use in the rest of this guide.
These will be used in the YAML Examples for use with Istio. 

* [DockerHub Attendees Version 1 Image](https://hub.docker.com/layers/196621151/jpgough/attendees/v1/images/sha256-6e3534ba9091c379f04e77c06ee76e643d756c426f86fea498c5f2385b78e569?context=repo)
* [DockerHub Attendees Version 2 Image](https://hub.docker.com/layers/196652410/jpgough/attendees/v2/images/sha256-864888d83102dfb23d7f00e5f0309a929cc7ab7a5ce1d64ac70c3129f0d5d66d?context=repo)

### Setting up AKS

#### Pre-Requisites 

* You will need an Azure account or Azure subscription, alternatively you can feel free to deploy to your own k8s cluster

#### Steps

On Kubernetes Services create a new cluster, the following configuration worked well for me:

* Cluster Preset Configuration change to Dev/Test
* Node size change to B2ms - saving a small amount of credit
* Node count set to 2
* Review and Create

Grab a coffee as that usually takes about 5 minutes to fire up. 

The next step is to connect to the cluster using the az tool, install guide is [here](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli).
Click connect on your AKS cluster (on browser) and run the `az aks get-credentials` command.
Running this command will set up `kubectl` to connect to the cluster for you, magic!

`kubectl get pods` should now return.

### Deploying Istio 

### Deploying and Testing the APIs

### Exploring Traffic Management
