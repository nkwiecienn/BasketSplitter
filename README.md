<h1>Basket Splitter</h1>
<h3>Overview</h3>

In our online supermarket, we are expanding our product range to include 
non-food items, such as electronics and home goods, which often cannot be 
delivered using our standard delivery vans due to their size or because 
they are sourced from external suppliers. To address this, we've developed 
a delivery optimization system that categorizes products in a customer's 
basket into delivery groups to minimize the number of deliveries required.

<h3>Input</h3>

The Input consists of: 
- Json file (config.json) with the supermarket configuration
which is represented by a map - the keys being the products offered by the market
and the value a list with possible delivery methods for this product.
  The absolute path to the configuration file is needed when initializing the BasketSplitter class.
- List of products in customers basket to calculate the delivery groups 
(passed in the split method of BastetSplitter class).



<h3>Output</h3>

The output is a map with its keys being the minimal list of delivery
methods and their values the products that are meant to be delivered with
this method so that it maximizes the number of products taken using one method.

<h3>Constraints</h3>

In the product catalog (configuration file) there is:

- A maximum of 1000 products;
- Up to 10 different delivery methods

A customer's cart contains a maximum of 100 products

<h3>Components</h3>
<h4>1. BasketSplitter.java </h4>

Responsible for splitting the customers basket into groups.
The algorithm is as it follows:
- First it reverses the configuration map so that the keys represent
means of transport and its keys the products the supermarket can deliver with them.
- Then it loops over the map to find the transport that can deliver the largest amount of
products and removes those products from the entire map so that in the
next iteration they are not taken into account.
- The method ends when all products have their delivery method found.

<h4>2. MapOperations.java </h4>

Provides utility functions for the main class, which include reversing
the map, finding the longest item list among the map's values and removing
those items from the map as described before.

<h4>3. ReadJson.java </h4>

Handles the input for reading the configuration and baskets Json files
(the second one used only for testing).

<h3>Testing</h3>

To use this library you should make an instance of BasketSplitter class
and use the public method split() with input as described above.