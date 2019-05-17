[![Build Status](https://travis-ci.org/TAMULib/Scholars.svg?branch=master)](https://travis-ci.org/TAMULib/Scholars)
[![Coverage Status](https://coveralls.io/repos/github/TAMULib/Scholars/badge.svg)](https://coveralls.io/github/TAMULib/Scholars)

# TAMU Scholars

Texas A&M University has been using <a href="https://wiki.duraspace.org/display/VIVO/VIVO">VIVO</a> for a few years now and our Scholarly Communications unit has quite a bit of traction here in its use.  While other options existed at the time of this project none of them took advantage of current technology trends.  This combined with the requirements and deadline of internal units at Texas A&M University we decided to create our own front end.  This project was conceived, and started prior to the creation of the <a href="https://wiki.duraspace.org/display/VIVO/VIVO+Scholar+Task+Force">VIVO Scholar Task Force</a>.  But, it does follow the same idea.  

<img src="https://webassets.library.tamu.edu/public/files/scholars-ui.png">

This replacement front end is based on <a href="https://lucene.apache.org/solr/">Solr</a>, <a href="https://spring.io/projects/spring-data-solr">Spring Data</a>, and <a href="https://angular.io/guide/universal">Angular Universal</a>.  The basic goals of this front end are:
<ul>
<li>Align the technology stack as much as possible with the existing VIVO stack to assist with ease of implementation by others if they choose especially smaller libraries.</li>
<li>Read only UI.  NO updating back to the triple store.</li>
<li>100% Search Engine Optimization.  IE:  A person / crawler does not need JavaScript enabled for page rendering.  Server side, and Client side rendering if needed.</li>
</ul>

TAMULib Scholars currently harvest directly from VIVO’s triple store and for each high level model in VIVO there is a Solr collection and each of its document properties are populated from parsing response of a SparQL query in which isolates the desired value. We are using Spring Apache Solr with explicit Java models representing a Solr document and utilize the provided implementation of a CRUD repository of the Solr documents.  At runtime each Solr collection can be initiated and re-indexed if needed to dynamically pick up new fields added to VIVO’s triple store.


# Docker Setup:

This project uses Docker version 18.09.2 in order to use docker-compose version 3. Once you've installed it, it requires minimal work to get
started. 

Please, this set up uses solr 7.7.1 because the existing jars work with that version of solr.

Once, you have above Docker version installed, you just have to run 'docker-compose up' in order to get started.
 
Currently, middleware --> index --> onStartup = 'true' in application.yml, which means it will index all the data when you first start 'docker-compose up' and indexing take little while to complete.

The recommended way is to have middleware --> index --> onStartup = 'false' so you will be able to visit all the pages but there will be no data. 

Currently, all maven libraries and data will be cached so taking docker containers down will keep this cache so next time it does not need to load anything.

In the future, we want to map the code base with volume mounts in docker compose so any code changes does not need restart of docker-compose.