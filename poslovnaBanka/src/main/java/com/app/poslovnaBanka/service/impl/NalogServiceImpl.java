package com.app.poslovnaBanka.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.poslovnaBanka.DTO.NalogZaPrenos;
import com.app.poslovnaBanka.service.NalogService;

@Service
public class NalogServiceImpl implements NalogService{
	
	@Override
	public void exportNalog(com.app.poslovnaBanka.modeli.NalogZaPrenos nalog) {
		Element nalogXml = new Element("nalog");
		
		Element nalogodavac = new Element("nalogodavac");
		nalogodavac.setText(nalog.getNalogodavac());
		
		Element svrhaPlacanja = new Element("svrha_placanja");
		svrhaPlacanja.setText(nalog.getSvrhaPlacanja());
		
		Element primalac = new Element("primalac");
		primalac.setText(nalog.getPrimalac());
		
		Element datumPrijema = new Element("datum_prijema");
			datumPrijema.setText(new Date().toString());
		
		Element sifraPlacanja = new Element("sifra_placanja");
		sifraPlacanja.setText(Integer.toString(nalog.getSifraPlacanja()));
		
		Element valuta = new Element("valuta");
		valuta.setText(nalog.getValuta().getNaziv());
		
		Element iznos = new Element("iznos");
		iznos.setText(Double.toString(nalog.getIznos()));
		
		Element racunDuznika = new Element("racun_duznika");
		racunDuznika.setText(nalog.getRacunNalogodavca());
		
		Element modelZaduzenja = new Element("model_zaduzenja");
		modelZaduzenja.setText(Integer.toString(nalog.getModelNalogodavca()));
		
		Element pozivNaBrojZaduzenja = new Element("poziv_na_broj_zaduzenja");
		pozivNaBrojZaduzenja.setText(nalog.getPozivNaBrojNalogodavca());
		
		Element racunPrimaoca = new Element("racun_primaoca");
		racunPrimaoca.setText(nalog.getRacunPrimaoca());
		
		Element modelOdobrenja = new Element("model_odobrenja");
		modelOdobrenja.setText(Integer.toString(nalog.getModelPrimaoca()));
		
		Element pozivNaBrojOdobrenja = new Element("poziv_na_broj_odobrenja");
		pozivNaBrojOdobrenja.setText(nalog.getPozivNaBrojPrimaoca());
		
		Element datumValute = new Element("datum_valute");
			datumValute.setText(new Date().toString());
		
		Element hitno = new Element("hitno");
		if (nalog.isHitno()) {
			hitno.setText("DA");	
		} else {
			hitno.setText("NE");
		}
		
		nalogXml.addContent(nalogodavac);
		nalogXml.addContent(svrhaPlacanja);
		nalogXml.addContent(primalac);
		nalogXml.addContent(datumPrijema);
		nalogXml.addContent(sifraPlacanja);
		nalogXml.addContent(valuta);
		nalogXml.addContent(iznos);
		nalogXml.addContent(racunDuznika);
		nalogXml.addContent(modelZaduzenja);
		nalogXml.addContent(pozivNaBrojZaduzenja);
		nalogXml.addContent(racunPrimaoca);
		nalogXml.addContent(modelOdobrenja);
		nalogXml.addContent(pozivNaBrojOdobrenja);
		nalogXml.addContent(datumValute);
		nalogXml.addContent(hitno);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		Document doc = new Document(nalogXml);
		try {
			PrintWriter out = new PrintWriter("src/main/resources/static/xml/Nalog.xml");
			xmlOutput.output(doc, out);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void export(NalogZaPrenos nalog) {
		Element nalogXml = new Element("nalog");
		
		Element nalogodavac = new Element("nalogodavac");
		nalogodavac.setText(nalog.getNalogodavac());
		
		Element svrhaPlacanja = new Element("svrha_placanja");
		svrhaPlacanja.setText(nalog.getSvrhaPlacanja());
		
		Element primalac = new Element("primalac");
		primalac.setText(nalog.getPrimalac());
		
		Element mestoPrijema = new Element("mesto_prijema");
		mestoPrijema.setText(nalog.getMestoPrijema());
		
		Element datumPrijema = new Element("datum_prijema");
		if (nalog.getDatumPrijema() != null ) {
			datumPrijema.setText(nalog.getDatumPrijema().toString());
		}
		
		Element sifraPlacanja = new Element("sifra_placanja");
		sifraPlacanja.setText(nalog.getSifraPlacanja());
		
		Element valuta = new Element("valuta");
		valuta.setText(nalog.getValuta());
		
		Element iznos = new Element("iznos");
		iznos.setText(Double.toString(nalog.getIznos()));
		
		Element racunDuznika = new Element("racun_duznika");
		racunDuznika.setText(nalog.getRacunDuznika());
		
		Element modelZaduzenja = new Element("model_zaduzenja");
		modelZaduzenja.setText(nalog.getModelZaduzenja());
		
		Element pozivNaBrojZaduzenja = new Element("poziv_na_broj_zaduzenja");
		pozivNaBrojZaduzenja.setText(nalog.getPozivNaBrojZaduzenja());
		
		Element racunPrimaoca = new Element("racun_primaoca");
		racunPrimaoca.setText(nalog.getRacunPrimaoca());
		
		Element modelOdobrenja = new Element("model_odobrenja");
		modelOdobrenja.setText(nalog.getModelOdobrenja());
		
		Element pozivNaBrojOdobrenja = new Element("poziv_na_broj_odobrenja");
		pozivNaBrojOdobrenja.setText(nalog.getPozivNaBrojOdobrenja());
		
		Element datumValute = new Element("datum_valute");
		if (nalog.getDatumValute() != null) {
			datumValute.setText(nalog.getDatumValute().toString());
		}
		
		Element hitno = new Element("hitno");
		if (nalog.isHitno()) {
			hitno.setText("DA");	
		} else {
			hitno.setText("NE");
		}
		
		nalogXml.addContent(nalogodavac);
		nalogXml.addContent(svrhaPlacanja);
		nalogXml.addContent(primalac);
		nalogXml.addContent(mestoPrijema);
		nalogXml.addContent(datumPrijema);
		nalogXml.addContent(sifraPlacanja);
		nalogXml.addContent(valuta);
		nalogXml.addContent(iznos);
		nalogXml.addContent(racunDuznika);
		nalogXml.addContent(modelZaduzenja);
		nalogXml.addContent(pozivNaBrojZaduzenja);
		nalogXml.addContent(racunPrimaoca);
		nalogXml.addContent(modelOdobrenja);
		nalogXml.addContent(pozivNaBrojOdobrenja);
		nalogXml.addContent(datumValute);
		nalogXml.addContent(hitno);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		Document doc = new Document(nalogXml);
		try {
			PrintWriter out = new PrintWriter("src/main/resources/static/xml/Nalog.xml");
			xmlOutput.output(doc, out);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public NalogZaPrenos importuj(MultipartFile file) {
		SAXBuilder saxBuilder = new SAXBuilder();
		NalogZaPrenos nalog = new NalogZaPrenos();
		try {
			Document document = saxBuilder.build(convert(file));
			Element root = document.getRootElement();
			nalog.setNalogodavac(root.getChild("nalogodavac").getText());
			nalog.setSvrhaPlacanja(root.getChild("svrha_placanja").getText());
			nalog.setPrimalac(root.getChild("primalac").getText());
			nalog.setMestoPrijema(root.getChildText("mesto_prijema"));
			
			if (!root.getChildText("datum_prijema").equals("")) {
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sdf1.parse(root.getChildText("datum_prijema"));
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());  
				nalog.setDatumPrijema(sqlDate);
			}
			
			nalog.setSifraPlacanja(root.getChildText("sifra_placanja"));
			nalog.setValuta(root.getChildText("valuta"));
			nalog.setIznos(Double.parseDouble(root.getChildText("iznos")));
			nalog.setRacunDuznika(root.getChildText("racun_duznika"));
			nalog.setModelZaduzenja(root.getChildText("model_zaduzenja"));
			nalog.setPozivNaBrojZaduzenja(root.getChildText("poziv_na_broj_zaduzenja"));
			nalog.setRacunPrimaoca(root.getChildText("racun_primaoca"));
			nalog.setModelOdobrenja(root.getChildText("model_odobrenja"));
			nalog.setPozivNaBrojOdobrenja(root.getChildText("poziv_na_broj_odobrenja"));
			
			if (!root.getChildText("datum_valute").equals("")) {
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date2 = sdf2.parse(root.getChildText("datum_valute"));
				java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());  
				nalog.setDatumValute(sqlDate2);
			}
			if (root.getChildText("hitno").equals("DA")) {
				nalog.setHitno(true);
			} else {
				nalog.setHitno(false);
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		return nalog;
	}

	public File convert(MultipartFile file)
	{    
		File convFile = new File(file.getOriginalFilename());
	    try {
	    

			convFile.createNewFile();
		
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    } catch (IOException e) {
			e.printStackTrace();
		} 
	    return convFile;
	}
	
}
