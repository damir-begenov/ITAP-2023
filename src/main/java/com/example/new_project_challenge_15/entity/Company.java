package com.example.new_project_challenge_15.entity;

import com.example.new_project_challenge_15.entity.rels.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node("COMPANY")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    public String PersonID;
    @Property("ИИН/БИН")
    public String IINBIN;
    @Property("Тип")
    public String Type;
    public String Label;
    @Property("Наименование")
    public String Name;
    public String Source;
    @Property("Бухгалтер")
    public String Buhgalter;
    @Property("НДС")
    public String NDS;
    @Property("Приказ о снятии с регистрационного учета")
    public String PRIKAZ_O_SNYATYA;
    @Property("Бездействующие ЮЛ")
    public String BEZDEYSTVIA_UL;
    @Property("Статус ОПГ")
    public String STATUS_OPG;
    @Property("Блок ЭСФ")
    public String BLOCK_ESF;
    @Property("Статья ЕРДР")
    public String STATYA_ERDR;
    @Property("Статус ЕРДР")
    public String STATUS_ERDR;
    @Property("Орган регистрации")
    public String ORGAN_REGISTER;
    @Property("ФПГ")
    public String FPG;
    @Property("Направлено в")
    public String Napravlenio_V;
    @Property("Лицензия")
    public String License;
    @Property("Статус участника МФЦА")
    public String Status_Uchastnika_MFCA;
    @Property("Номер сделки")
    public String Nomer_sdelki;
    @Property("Уникальный ID сделки")
    public String Unique_id;
    @Property("Статус неплатежеспособности")
    public String Status_neplatejasposobnosti;

    public String getStatus_neplatejasposobnosti() {
        return Status_neplatejasposobnosti;
    }

    public void setStatus_neplatejasposobnosti(String status_neplatejasposobnosti) {
        Status_neplatejasposobnosti = status_neplatejasposobnosti;
    }

    @Relationship(type = "BUHGALTER", direction = Relationship.Direction.OUTGOING)
    private List<BUHGALTER> buhgalters;

    @Relationship(type = "DETDOM_HIST", direction = Relationship.Direction.OUTGOING)
    private List<DETDOM_HIST> detdomHistList;
    @Relationship(type = "DFO_AFF_UL", direction = Relationship.Direction.OUTGOING)
    private List<DFO_AFF_UL> dfoAffUls;

    @Relationship(type = "ESF_100", direction = Relationship.Direction.OUTGOING)
    private List<ESF_100> esf100s;
    @Relationship(type = "ESF_100", direction = Relationship.Direction.INCOMING)
    private List<ESF_100> esf100sIncome;

    @Relationship(type = "ESF_5and10", direction = Relationship.Direction.INCOMING)
    private List<ESF_5and10> esf5and10s;
    @Relationship(type = "ESF_5and10", direction = Relationship.Direction.OUTGOING)
    private List<ESF_5and10> esf5and10sOut;

    @Relationship(type = "ESF_10and100", direction = Relationship.Direction.INCOMING)
    private List<ESF_10and100> esf_10and100s;
    @Relationship(type = "ESF_10and100", direction = Relationship.Direction.OUTGOING)
    private List<ESF_10and100> esf_10and100sOut;
    @Relationship(type = "ESF_10and50", direction = Relationship.Direction.OUTGOING)
    private List<ESF_10and50> esf10and50s;
    @Relationship(type = "ESF_10and50", direction = Relationship.Direction.INCOMING)
    private List<ESF_10and50> esf10and50sIncome;

    @Relationship(type = "ESF_50and100", direction = Relationship.Direction.OUTGOING)
    private List<ESF_50and100> esf50and100s;
    @Relationship(type = "ESF_50and100", direction = Relationship.Direction.INCOMING)
    private List<ESF_50and100> esf50and100sIncome;

    @Relationship(type = "DIRECTOR_CUR", direction = Relationship.Direction.OUTGOING)
    private List<DIRECTOR_CUR> directorCurs;

    @Relationship(type = "DIRECTOR_HIST", direction = Relationship.Direction.OUTGOING)
    private List<DIRECTOR_HIST> directorHists;

    public List<DIRECTOR_HIST> getDirectorHists() {
        return directorHists;
    }

    public void setDirectorHists(List<DIRECTOR_HIST> directorHists) {
        this.directorHists = directorHists;
    }

    public List<DIRECTOR_CUR> getDirectorCurs() {
        return directorCurs;
    }

    public void setDirectorCurs(List<DIRECTOR_CUR> directorCurs) {
        this.directorCurs = directorCurs;
    }

    @Relationship(type = "FOUNDER_CUR", direction = Relationship.Direction.INCOMING)
    private List<FOUNDER_CUR> founderCurs;

    @Relationship(type = "FOUNDER_HIST", direction = Relationship.Direction.INCOMING)
    private List<FOUNDER_HIST> founderHists;

    @Relationship(type = "FPG", direction = Relationship.Direction.OUTGOING)
    private List<FPG> fpgs;

    @Relationship(type = "GOSZAKUP", direction = Relationship.Direction.OUTGOING)
    private List<GOSZAKUP> goszakups;

    public List<ESF_100> getEsf100sIncome() {
        return esf100sIncome;
    }

    public void setEsf100sIncome(List<ESF_100> esf100sIncome) {
        this.esf100sIncome = esf100sIncome;
    }

    public List<ESF_10and100> getEsf_10and100sOut() {
        return esf_10and100sOut;
    }

    public void setEsf_10and100sOut(List<ESF_10and100> esf_10and100sOut) {
        this.esf_10and100sOut = esf_10and100sOut;
    }

    public List<ESF_10and50> getEsf10and50sIncome() {
        return esf10and50sIncome;
    }

    public void setEsf10and50sIncome(List<ESF_10and50> esf10and50sIncome) {
        this.esf10and50sIncome = esf10and50sIncome;
    }

    public List<ESF_50and100> getEsf50and100sIncome() {
        return esf50and100sIncome;
    }

    public void setEsf50and100sIncome(List<ESF_50and100> esf50and100sIncome) {
        this.esf50and100sIncome = esf50and100sIncome;
    }

    public List<ESF_5and10> getEsf5and10sOut() {
        return esf5and10sOut;
    }

    public void setEsf5and10sOut(List<ESF_5and10> esf5and10sOut) {
        this.esf5and10sOut = esf5and10sOut;
    }

    @Relationship(type = "IP", direction = Relationship.Direction.OUTGOING)
    private List<IP> ips;

    @Relationship(type = "IP_KX", direction = Relationship.Direction.OUTGOING)
    private List<IP_KX> ipKxes;

    @Relationship(type = "NTR_UL_FL", direction = Relationship.Direction.OUTGOING)
    private List<NTR_UL_FL> ntrUlFls;

    @Relationship(type = "OPG", direction = Relationship.Direction.OUTGOING)
    private List<OPG> opgs;

    @Relationship(type = "PDL", direction = Relationship.Direction.OUTGOING)
    private List<PDL> pdls;

    @Relationship(type = "REG_ADDRESS", direction = Relationship.Direction.OUTGOING)
    private List<REG_ADDRESS> regAddresses;

    @Relationship(type = "REG_ADDRESS_UL", direction = Relationship.Direction.OUTGOING)
    private List<REG_ADDESS_UL> regAddessUls;

    @Relationship(type = "SUDIM", direction = Relationship.Direction.OUTGOING)
    private List<SUDIM> sudims;

    @Relationship(type = "UCHILSYA", direction = Relationship.Direction.OUTGOING)
    private List<UCHILSYA> uchilsyas;

    @Relationship(type = "WORKER_CUR", direction = Relationship.Direction.OUTGOING)
    private List<WORKER_CUR> workerCurs;

    @Relationship(type = "WORKER_HIST", direction = Relationship.Direction.OUTGOING)
    private List<WORKER_HIST> workerHists;



    public List<BUHGALTER> getBuhgalters() {
        return buhgalters;
    }

    public void setBuhgalters(List<BUHGALTER> buhgalters) {
        this.buhgalters = buhgalters;
    }

    public List<DETDOM_HIST> getDetdomHistList() {
        return detdomHistList;
    }

    public void setDetdomHistList(List<DETDOM_HIST> detdomHistList) {
        this.detdomHistList = detdomHistList;
    }

    public List<DFO_AFF_UL> getDfoAffUls() {
        return dfoAffUls;
    }

    public void setDfoAffUls(List<DFO_AFF_UL> dfoAffUls) {
        this.dfoAffUls = dfoAffUls;
    }

    public List<ESF_100> getEsf100s() {
        return esf100s;
    }

    public void setEsf100s(List<ESF_100> esf100s) {
        this.esf100s = esf100s;
    }

    public List<ESF_10and100> getEsf_10and100s() {
        return esf_10and100s;
    }

    public void setEsf_10and100s(List<ESF_10and100> esf_10and100s) {
        this.esf_10and100s = esf_10and100s;
    }

    public List<ESF_10and50> getEsf10and50s() {
        return esf10and50s;
    }

    public void setEsf10and50s(List<ESF_10and50> esf10and50s) {
        this.esf10and50s = esf10and50s;
    }

    public List<ESF_50and100> getEsf50and100s() {
        return esf50and100s;
    }

    public void setEsf50and100s(List<ESF_50and100> esf50and100s) {
        this.esf50and100s = esf50and100s;
    }

    public List<ESF_5and10> getEsf5and10s() {
        return esf5and10s;
    }

    public void setEsf5and10s(List<ESF_5and10> esf5and10s) {
        this.esf5and10s = esf5and10s;
    }

    public List<FOUNDER_CUR> getFounderCurs() {
        return founderCurs;
    }

    public void setFounderCurs(List<FOUNDER_CUR> founderCurs) {
        this.founderCurs = founderCurs;
    }

    public List<FOUNDER_HIST> getFounderHists() {
        return founderHists;
    }

    public void setFounderHists(List<FOUNDER_HIST> founderHists) {
        this.founderHists = founderHists;
    }

    public List<com.example.new_project_challenge_15.entity.rels.FPG> getFpgs() {
        return fpgs;
    }

    public void setFpgs(List<com.example.new_project_challenge_15.entity.rels.FPG> fpgs) {
        this.fpgs = fpgs;
    }

    public List<GOSZAKUP> getGoszakups() {
        return goszakups;
    }

    public void setGoszakups(List<GOSZAKUP> goszakups) {
        this.goszakups = goszakups;
    }

    public List<IP> getIps() {
        return ips;
    }

    public void setIps(List<IP> ips) {
        this.ips = ips;
    }

    public List<IP_KX> getIpKxes() {
        return ipKxes;
    }

    public void setIpKxes(List<IP_KX> ipKxes) {
        this.ipKxes = ipKxes;
    }

    public List<NTR_UL_FL> getNtrUlFls() {
        return ntrUlFls;
    }

    public void setNtrUlFls(List<NTR_UL_FL> ntrUlFls) {
        this.ntrUlFls = ntrUlFls;
    }

    public List<OPG> getOpgs() {
        return opgs;
    }

    public void setOpgs(List<OPG> opgs) {
        this.opgs = opgs;
    }

    public List<PDL> getPdls() {
        return pdls;
    }

    public void setPdls(List<PDL> pdls) {
        this.pdls = pdls;
    }

    public List<REG_ADDRESS> getRegAddresses() {
        return regAddresses;
    }

    public void setRegAddresses(List<REG_ADDRESS> regAddresses) {
        this.regAddresses = regAddresses;
    }

    public List<REG_ADDESS_UL> getRegAddessUls() {
        return regAddessUls;
    }

    public void setRegAddessUls(List<REG_ADDESS_UL> regAddessUls) {
        this.regAddessUls = regAddessUls;
    }

    public List<SUDIM> getSudims() {
        return sudims;
    }

    public void setSudims(List<SUDIM> sudims) {
        this.sudims = sudims;
    }

    public List<UCHILSYA> getUchilsyas() {
        return uchilsyas;
    }

    public void setUchilsyas(List<UCHILSYA> uchilsyas) {
        this.uchilsyas = uchilsyas;
    }

    public List<WORKER_CUR> getWorkerCurs() {
        return workerCurs;
    }

    public void setWorkerCurs(List<WORKER_CUR> workerCurs) {
        this.workerCurs = workerCurs;
    }

    public List<WORKER_HIST> getWorkerHists() {
        return workerHists;
    }

    public void setWorkerHists(List<WORKER_HIST> workerHists) {
        this.workerHists = workerHists;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }




    public String getIINBIN() {
        return IINBIN;
    }

    public void setIINBIN(String IINBIN) {
        this.IINBIN = IINBIN;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getBuhgalter() {
        return Buhgalter;
    }

    public void setBuhgalter(String buhgalter) {
        Buhgalter = buhgalter;
    }

    public String getNDS() {
        return NDS;
    }

    public void setNDS(String NDS) {
        this.NDS = NDS;
    }

    public String getPRIKAZ_O_SNYATYA() {
        return PRIKAZ_O_SNYATYA;
    }

    public void setPRIKAZ_O_SNYATYA(String PRIKAZ_O_SNYATYA) {
        this.PRIKAZ_O_SNYATYA = PRIKAZ_O_SNYATYA;
    }

    public String getBEZDEYSTVIA_UL() {
        return BEZDEYSTVIA_UL;
    }

    public void setBEZDEYSTVIA_UL(String BEZDEYSTVIA_UL) {
        this.BEZDEYSTVIA_UL = BEZDEYSTVIA_UL;
    }

    public String getSTATUS_OPG() {
        return STATUS_OPG;
    }

    public void setSTATUS_OPG(String STATUS_OPG) {
        this.STATUS_OPG = STATUS_OPG;
    }

    public String getBLOCK_ESF() {
        return BLOCK_ESF;
    }

    public void setBLOCK_ESF(String BLOCK_ESF) {
        this.BLOCK_ESF = BLOCK_ESF;
    }

    public String getSTATYA_ERDR() {
        return STATYA_ERDR;
    }

    public void setSTATYA_ERDR(String STATYA_ERDR) {
        this.STATYA_ERDR = STATYA_ERDR;
    }

    public String getSTATUS_ERDR() {
        return STATUS_ERDR;
    }

    public void setSTATUS_ERDR(String STATUS_ERDR) {
        this.STATUS_ERDR = STATUS_ERDR;
    }

    public String getORGAN_REGISTER() {
        return ORGAN_REGISTER;
    }

    public void setORGAN_REGISTER(String ORGAN_REGISTER) {
        this.ORGAN_REGISTER = ORGAN_REGISTER;
    }

    public String getFPG() {
        return FPG;
    }

    public void setFPG(String FPG) {
        this.FPG = FPG;
    }

    public String getNapravlenio_V() {
        return Napravlenio_V;
    }

    public void setNapravlenio_V(String napravlenio_V) {
        Napravlenio_V = napravlenio_V;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getStatus_Uchastnika_MFCA() {
        return Status_Uchastnika_MFCA;
    }

    public void setStatus_Uchastnika_MFCA(String status_Uchastnika_MFCA) {
        Status_Uchastnika_MFCA = status_Uchastnika_MFCA;
    }

    public String getNomer_sdelki() {
        return Nomer_sdelki;
    }

    public void setNomer_sdelki(String nomer_sdelki) {
        Nomer_sdelki = nomer_sdelki;
    }

    public String getUnique_id() {
        return Unique_id;
    }

    public void setUnique_id(String unique_id) {
        Unique_id = unique_id;
    }

}
