# Test for Meli

## Description
The api must consume a **MELI** api where you could find an items and its children
You should use a strategy to save the data when you've consumed api service.

##Technologies
 * Java - **Spring Boot**
 * MySql
 * Docker 
 
## Assumption
* It's assumed that the application must have high availability and optimal performance must be guaranteed.
## Upgrades
* You could use more functional programming as [VAVR](https://www.vavr.io/) and  [immutables](https://immutables.github.io/)
* You could use postman and [newman](https://www.npmjs.com/package/newman) to ensure your e2e
* You must create functional test
* You could add swagger documentation
* if you want that the app works with workloads you could deploy in [AWS](https://aws.amazon.com/) and use EC2, ELB and EBS
 
## Metrics

- `GET /actuator/health` 
- `GET /actuator/metrics`
- `GET /metrics`

## How to deploy it?
* `git pull` 
* `docker-compose  -f docker-compose.yml up -d`
* enjoy :)

 
