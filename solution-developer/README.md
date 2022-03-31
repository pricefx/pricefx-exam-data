# Solution Developer Exam - Initial partition content

This module contains initial configuration and sample data, which serve as starting point for the Solution Developer Exam.

The deployment of the configuration to the partition will be done using [_Stream_ Maven plugin](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3806330885/Pricefx+Stream+Maven+Plugin).
This plugin is already referenced in the _pom.xml_ file of this project, so you do not need to install it or something.
All you need is working Maven, which is included out-of-the-box in IntelliJ.

To deploy content of this module to a partition, you need:

1. Access information for a new empty partition:
   * Pricefx server URL
   * partition name
   * username and password of an admin user, who can deploy configurations
   
2.  Add settings for the plugin - follow instructions on [Adding a Maven Profile](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3804922316/Adding+a+Maven+Profile).

3. To deploy the content (screenshots of [goal executions are here](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3807380252/Execute+Goals)), you need to
   * select the Maven Profile, which has connection to your empty partition 
   * execute the goal _pricefx-deploy-all_ of the _pricefx-stream_ plugin.