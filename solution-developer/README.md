# Solution Developer Exam - Initial partition content

This module contains initial configuration and sample data, which serve as starting point for the Solution Developer Exam.

The deployment of the configuration to the partition will be done using [_Stream_ Maven plugin](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3806330885/Pricefx+Stream+Maven+Plugin).
The plugin is already referenced in the _pom.xml_ file of this project, so you do not need to set it up.
All you need is working Maven, which is included out-of-the-box in IntelliJ.

To deploy the project to the empty exam partition, you will need the access information (URL, partition name, username and password), which will be provided once you sign up for the exam.


To upload the project – including the data – to your exam partition, please follow the steps below:

1. To connect the plugin to the exam partition, update your Maven `settings.xml` file to specify your Maven exam profile. Please see following document for details:  [Connect plugin to partition](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3804922316/Connect+Stream+Plugin+to+Partition).

2. To deploy the content of this project, in the Maven tool do the following steps. Please see following document for details: [Use the plugin](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3807380252/Use+the+Plugin) 
   * select the Maven Profile, which has connection to your empty partition 
   * in the artifact/module _solution-developer_, locate plugin _pricefx-stream_ and execute the goal _pricefx-deploy-all_.
   
3. Verify that all is deployed correctly. If no errors came up during deployment, you should be all set up, nevertheless we recommend reviewing the partition manually too. Log in to the partition via browser, and review:
   * data in the _Transaction_ Datamart - ensure to make all fields visible, when reviewing. Generally all fields should have some reasonable data, so review if you can see something in all fields.  