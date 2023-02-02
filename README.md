# irrigation-system

An irrigation system which helps the automatic irrigation of agricultural lands without human intervention.
It works as follows:
1. Application is based on Rest APIs. Endpoints are given below.
2. User will provide the details to add land plot like what is area of plot in acre(s) and the time slot when the irrigation to be started. 
3. Further user will provide the irrigation details like for how long (in minutes) water will be supplied and amount of water shall be supplied.
4. User can update the details of plot and irrigation
5. User can also fetch either all details of plots or by specific plot by providing the id

# Technical Stack

1. Java 17
2. Spring boot 3.0.2
3. Junit 5
4. Gradle 7.6

# Endpoints

1. Get  "/land/plots"           - Get a list of plots
2. Get  "/land/plot/{plotId}"   - Get details of specific plot by providing Plot Id
3. Post "/land/plot"            - Add Plot
4. Put  "/land/plot/{plotId}"   - Update details of specific plot by providing the Plot Id in path variable and details shold be provided in the request body.
5. Delete "/land/plot/{plotId}" - Delete plot by providing the Plot Id.

# Testing

Test cases are implemented by using Junit 5 library. Further 100% code coverage is achieved. 