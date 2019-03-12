#!/bin/bash

serverName=study-jenkinsk8s
workDir=/mnt/k8sApp/$serverName
imageRepertory=47.94.159.51/dev
serverVersion=latest



imageName=$serverName_image

function buildImage(){
    docker image build -t $imageName:$serverVersion $workDir
}

function pushImage(){
    docker tag $imageName:$serverVersion $imageRepertory/$imageName:$serverVersion
    docker push $imageRepertory/$imageName:$serverVersion
}

function k8sDeploy(){
    kubectl apply -f $serverName.yaml
}

buildImage

pushImage

k8sDeploy