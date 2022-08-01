job('ejemplodls2'){
    description('adwawda')
  scm {
    git ('https://github.com/macloujulian/jenkins.job.parametrizado.git','main') { node -> 
      node / gitConfigName('jesus')
      node / gitConfigEmail ('jesuscicloinformatica@gmail.com')
    }  
  }
  parameters {
      stringParam('nombre', defaultValue = 'Jesus', description = 'description nombre')
	  choiceParam('planeta', ['mercurio', 'venus','tierra'])
	  booleanParam('agente', false)
  }
  triggers {
      cron ('8/7 * * * *')
  }
  steps {
      shell ("bash jobscript.sh")
  }
  publishers {
      mailer ('jesus@gmail.com', true, true)
  } 
}
