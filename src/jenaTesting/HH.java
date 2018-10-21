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
    	OntModel ontmodel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);  //����ģ��

    	String NS="http://OWLTEST/Things#";  //���λ��URI

    	//������Ͷ���������

    	OntClass animals=ontmodel.createClass(NS+"Animals");  

    	OntClass animalsname=ontmodel.createClass(NS+"AnimalsName");

    	//ֲ�����ֲ��������

    	OntClass plants=ontmodel.createClass(NS+"Plants");

    	OntClass plantsname=ontmodel.createClass(NS+"PlantsName");

    	//�������ֲ����Ķ����ϵrant

    	OntProperty rant=ontmodel.createObjectProperty(NS+"Rant");



    	OntProperty hasanimalsname=ontmodel.createObjectProperty(NS+"HasAnimalsName"); //�����ϵΪ�Ƿ��ж������ƣ���������animal���animalsname��

    	OntProperty hasplantsname=ontmodel.createObjectProperty(NS+"HasPlantsName");   //ͬ������plant��plantsname



    	OntProperty hasname=ontmodel.createDatatypeProperty(NS+"HasName");



    	hasanimalsname.addDomain(animals); //��animals��animalsname��������ϵ����

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



    	Individual a=animals.createIndividual(NS+"A");   //Individual�Ǿ��������

    	Individual b=animals.createIndividual(NS+"B");



    	Individual sheep=animalsname.createIndividual(NS+"Sheep");

    	Individual horse=animalsname.createIndividual(NS+"Horse");


    	a.addProperty(hasanimalsname, sheep);  //��aΪ���壬��hasanimalsnameΪν�ʣ����ԣ���ͷ������sheepΪ���󡣾ٸ����ӣ����ӣ�װ��ʳ��γ�һ��ģ����ӵ������Դa�������ģ��

    	
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

