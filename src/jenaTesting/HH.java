package jenaTesting;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class HH extends Object{
	//static final String inputFileName  = "vc-db-1.rdf";
    
    public static void main (String args[]) {
    	OntModel ontmodel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);  //创建模型

    	String NS="http://OWLTEST/Things#";  //存的位置URI

    	//动物类和动物名称类

    	OntClass animals=ontmodel.createClass(NS+"Animals");  

    	OntClass animalsname=ontmodel.createClass(NS+"AnimalsName");

    	//植物类和植物名称类

    	OntClass plants=ontmodel.createClass(NS+"Plants");

    	OntClass plantsname=ontmodel.createClass(NS+"PlantsName");

    	//动物类和植物类的对象关系rant

    	OntProperty rant=ontmodel.createObjectProperty(NS+"Rant");



    	OntProperty hasanimalsname=ontmodel.createObjectProperty(NS+"HasAnimalsName"); //这个关系为是否有动物名称，用来链接animal类和animalsname类

    	OntProperty hasplantsname=ontmodel.createObjectProperty(NS+"HasPlantsName");   //同理，链接plant和plantsname



    	OntProperty hasname=ontmodel.createDatatypeProperty(NS+"HasName");



    	hasanimalsname.addDomain(animals); //将animals和animalsname这两个联系起来

    	hasanimalsname.addRange(animalsname);



    	hasplantsname.addDomain(plants);

    	hasplantsname.addRange(plantsname);



    	rant.addDomain(animals);

    	rant.addRange(plants);



    	hasanimalsname.addDomain(animals);

    	hasanimalsname.addRange(animalsname);



    	hasplantsname.addDomain(plants);

    	hasplantsname.addRange(plantsname);



    	hasname.addDomain(animalsname);

    	hasname.addDomain(plantsname);



    	Individual a=animals.createIndividual(NS+"A");   //Individual是具体的例子

    	Individual b=animals.createIndividual(NS+"B");



    	Individual sheep=animalsname.createIndividual(NS+"Sheep");

    	Individual horse=animalsname.createIndividual(NS+"Horse");


    	a.addProperty(hasanimalsname, sheep);  //以a为主体，以hasanimalsname为谓词（属性，箭头），以sheep为对象。举个例子（盘子，装，食物）形成一个模型添加到与该资源a相关联的模型

    	
    	animalsname.addProperty(hasname, sheep);

    	animalsname.addProperty(hasname, horse);

    	Individual grass=plants.createIndividual(NS+"Grass");




    	System.out.println(ontmodel);


    	System.out.println("..............................");


    	for(Iterator i=ontmodel.listObjects();i.hasNext();){

    	Resource r=(Resource)i.next();

    	System.out.println(r.getLocalName());

    	}

    	System.out.println("..............................");



    	for (Iterator i=ontmodel.listIndividuals();i.hasNext();){

    	Individual ind=(Individual)i.next();

    	System.out.println(ind.getLocalName());

    	}

    	System.out.println("..............................");



    	for (Iterator i=ontmodel.listObjectProperties();i.hasNext();){

    	Property p=(Property)i.next();

    	System.out.println("Property:"+p.getLocalName());

    	for (Iterator j=ontmodel.listObjectsOfProperty(p);j.hasNext();){

    	Resource node=(Resource)j.next();

    	System.out.println("Objects:"+node.getLocalName());

    	}

    	}

    	System.out.println("..............................");



    	for (Iterator i=animalsname.listPropertyValues(hasname);i.hasNext();){

    	Resource value=(Resource)i.next();

    	System.out.println("HasName's values:"+value.getLocalName());

    	}

    	System.out.println("..............................");
        
    }
    }

