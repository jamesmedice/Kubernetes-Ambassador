1 - first you need to install Ambassador 
    follow : https://www.getambassador.io/docs/latest/tutorials/getting-started/

2 -to deploy the app you must RUN : skaffold run 

3 - in case you wanna run ambassador as nodeport, include the ambassador.yaml on skaffold.yaml

4 - for removing all components deployed :


kubectl delete FilterPolicy ouath2-policy
kubectl delete Filter oauth2-filter

kubectl delete -n default cronjob cronjob

kubectl delete -n default configmap scout.config.ambassador

kubectl delete -n default secret ambassador-token
kubectl delete -n default secret secret-env

kubectl delete -n default statefulset redis

kubectl delete -n default persistentvolumeclaim redis-volume-redis-0
kubectl delete -n default persistentvolume calculator-volume

kubectl delete -n default deployment ambassador
kubectl delete -n default deployment bootstorage-svc
kubectl delete -n default deployment oauth2

kubectl delete -n default service oauth2
kubectl delete -n default service ambassador
kubectl delete -n default service bootstorage-svc
kubectl delete -n default service redis