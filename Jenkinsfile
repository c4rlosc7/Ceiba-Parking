pipeline {  
//Donde se va a ejecutar el Pipeline  
  agent {
    label 'Slave_Induccion'
  }
  
  //Opciones específicas de Pipeline dentro del Pipeline  
  options {
    //Mantener artefactos y salida de consola para el # específico de ejecucionesrecientes del Pipeline.
    buildDiscarder(logRotator(numToKeepStr: '3'))
    //No permitir ejecuciones concurrentes de Pipeline
      disableConcurrentBuilds()  
  }
  
    //Una sección que define las herramientas para “autoinstalar” y poner en la PATH  
  tools {    
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master    
    gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master  
  }
  
    //Aquí comienzan los “items” del Pipeline  
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
	      checkout([$class: 'GitSCM', branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false, extensions: [], gitTool:
			'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId:'GitHub_c4rlosc7',url:'https://github.com/c4rlosc7/Ceiba-Parking']]])
      }
    }
    
    stage('Compile'){
            steps{
                echo "------------>Compile<------------"
                //sh 'gradle clean'
		sh 'gradle --b ./api-rest/build.gradle compileJava'		  
            }
        }    
    
    stage('Unit Tests') {      
      steps{        
        echo "------------>Unit Tests<------------"      
        sh 'gradle --b ./api-rest/build.gradle cleanTest test'
        sh 'gradle --b ./api-rest/build.gradle test'
        junit '**/api-rest/build/test-results/*.xml' //aggregate test results - JUnit
				jacoco classPattern:'**/api-rest/build/classes/java', execPattern:'**/api-rest/build/jacoco/jacocoTest.exec', sourcePattern:'**/src/main/java'
      }    
    }
    
    stage('Integration Tests') {      
      steps {
        echo "------------>Integration Tests<------------"  
        //sh 'gradle --b ./api-rest/build.gradle integrationTest'
      }    
    }        

  stage('Build') {      
    steps {
      echo "------------>Build<------------"
      //Construir sin tarea test que se ejecutó previamente
      sh 'gradle --b ./api-rest/build.gradle build -x test'      
    }    
  }

stage('Static Code Analysis') {
    steps
    {
      echo '------------>Análisis de código estático<------------'
      withSonarQubeEnv('Sonar') {
	   sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"             
        }     
    }
  }

}
	
post {    
  always {      
    echo 'This will always run'    
  }    
  success {      
    echo 'Esto correrá solo si se ejecuta satisfactoriamente'   
    // Se ejecutará correctamente, siempre y cuando exista la ruta expuesta
    junit '**/api-rest/build/test-results/*.xml'
  }    
  failure {      
    echo 'This will run only if failed' 
    //      Send notifications about a Pipeline to an email
    mail (to: 'carlos.martinez@ceiba.com.co',
               subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
               body: "Something is wrong with ${env.BUILD_URL}")
  }    
  unstable {      
    echo 'This will run only if the run was marked as unstable'    
  }    
  changed {      
    echo 'This will run only if the state of the Pipeline has changed'      
    echo 'For example, if the Pipeline was previously failing but is now successful'
    
    //      This will run only if the state of the Pipeline has changed
    //      For example, if the Pipeline was previously failing but is now successful'
    //      Send notifications about a Pipeline to an email
          mail (to: 'carlos.martinez@ceiba.com.co',
               subject: "Changed State Pipeline: ${currentBuild.fullDisplayName}",
               body: "The state of the Pipeline has changed. See ${env.BUILD_URL}")
  }  
 }    
}