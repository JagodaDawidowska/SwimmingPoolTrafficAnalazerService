# SwimmingPoolTrafficAnalazerService

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Project Status](#project-status)

## General Information
This project includes a REST API-based backend for a microservice for analyzing swimming pool traffic.
This backend includes:
- ORM, JPA specification, and Hibernate implementation for managing database activities and generating unique database requests
- modern project architecture
- controllers and HTTP request handling
- business logic to handle the functionalities of the application.
- utils for crawling the ZG MOSiR website and filtering desired information

## Technologies Used
- SpringBoot - framework for application development 
- MySQL - database. 
- Java - Language
- ORM - JPA specification, and Hibernate implementation for managing database activities and generating unique database requests
- Lombok - Library to help eliminate boilerplate code in model classes
- Spring Schedule - to schedule HTTP requests
- URL Reader - Web reader for crawling ZG MOSiR website

## Features
The functionalities the application fulfills: 
- feature to present all the collected data.
- feature in progress - to present data from a period specified by the user.
- feature to present data for the swimming pool/SPA within the current hour.
- feature to present data for the swimming pool/SPA within the current day.
- feature in progress - to present a chart with average data from the entire week.
- feature to present the current data.

## Project Status
Project is: In progress
