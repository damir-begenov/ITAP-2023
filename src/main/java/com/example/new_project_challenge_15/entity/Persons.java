package com.example.new_project_challenge_15.entity;

import com.example.new_project_challenge_15.entity.rels.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node("Person")
public class Persons {
    @Id
    @GeneratedValue
    public Long id;

    public String PersonID;
    @Property("Дата рождения")
    public String Data_Rozhdenya;
    @Property("Фамилия")
    public String Familia;
    @Property("Отчество")
    public String Otchestvo;
    @Property("ФИО")
    public String FIO;
    public String Source;
    public String Label;
    @Property("ИИН")
    public String IIN;
    @Property("Статус смерти")
    public String Death_Status;
    @Property("Мед. Орг.")
    public String Med_org;
    @Property("Статус Минздрав")
    public String Status_Minzdrav;
    @Property("Статус КУИС")

    public String Status_KUIS;
    @Property("Приставание в общественных местах")
    public String Pristavanie;
    @Property("Дата решения")
    public String Data_reshenya;
    @Property("Размер наложенного штрафа")
    public String Razmer_Shtrafa;
    @Property("Орган, выявивший правонарушение")
    public String Organ_pravanarushenya;
    @Property("Статья")
    public String Statya;
    @Property("Информация ПФР")
    public String PFR_Info;
    @Property("Аудитор")
    public String Autditor;
    @Property("Нотариус")
    public String Notarius;
    @Property("Адвокат")
    public String Advocat;
    @Property("Частный судебный исполнитель")
    public String Sud_ispolnitel;
    @Property("GLK")
    public String GLK;
    @Property("Пропавший без вести")
    public String Propal;
    @Property("Дата смерти:")
    public String Date_of_Death;
    @Property("RIP_date:")
    public String RIP_date;
 @Property("Должник по алиментам")
    public String Doljnik_po_alimentam;
 @Property("В розыске")
    public String V_Roziske;
 @Property("Статус должника")
    public String Status_doljnika;
   @Property("Статус неплатежеспособности")
    public String Status_neplatejasposobnosti;

    public String getStatus_neplatejasposobnosti() {
        return Status_neplatejasposobnosti;
    }

    public void setStatus_neplatejasposobnosti(String status_neplatejasposobnosti) {
        Status_neplatejasposobnosti = status_neplatejasposobnosti;
    }

    public String getDoljnik_po_alimentam() {
        return Doljnik_po_alimentam;
    }

    public void setDoljnik_po_alimentam(String doljnik_po_alimentam) {
        Doljnik_po_alimentam = doljnik_po_alimentam;
    }

    public String getV_Roziske() {
        return V_Roziske;
    }

    public void setV_Roziske(String v_Roziske) {
        V_Roziske = v_Roziske;
    }

    public String getStatus_doljnika() {
        return Status_doljnika;
    }

    public void setStatus_doljnika(String status_doljnika) {
        Status_doljnika = status_doljnika;
    }

    @Relationship(type = "BUHGALTER", direction = Relationship.Direction.OUTGOING)
    private List<BUHGALTER> buhgalters;

    @Relationship(type = "DETDOM_HIST", direction = Relationship.Direction.OUTGOING)
    private List<DETDOM_HIST> detdomHistList;

    @Relationship(type = "DFO_AFF_FIZ", direction = Relationship.Direction.OUTGOING)
    private List<DFO_AFF_FIZ> dfoAffFizs;

    @Relationship(type = "ESF_100", direction = Relationship.Direction.OUTGOING)
    private List<ESF_100> esf100s;
    @Relationship(type = "ESF_100", direction = Relationship.Direction.INCOMING)
    private List<ESF_100> esf100sIncome;

    @Relationship(type = "ESF_10and100", direction = Relationship.Direction.INCOMING)
    private List<ESF_10and100> esf_10and100s;
    @Relationship(type = "BLIZKIE_RODS", direction = Relationship.Direction.INCOMING)
    private List<BLIZKIE_RODS> blizkieRods;
    @Relationship(type = "BLIZKIE_RODS", direction = Relationship.Direction.OUTGOING)
    private List<BLIZKIE_RODS> blizkieRodsOut;
    @Relationship(type = "SIBLING", direction = Relationship.Direction.INCOMING)
    private List<SIBLING> siblings;
    @Relationship(type = "COUSIN", direction = Relationship.Direction.INCOMING)
    private List<COUSIN> cousins;
    @Relationship(type = "SIBLING", direction = Relationship.Direction.OUTGOING)
    private List<SIBLING> siblingsOut;
    @Relationship(type = "COUSIN", direction = Relationship.Direction.OUTGOING)
    private List<COUSIN> cousinsOut;

    public List<SIBLING> getSiblings() {
        return siblings;
    }

    public List<BLIZKIE_RODS> getBlizkieRodsOut() {
        return blizkieRodsOut;
    }

    public void setBlizkieRodsOut(List<BLIZKIE_RODS> blizkieRodsOut) {
        this.blizkieRodsOut = blizkieRodsOut;
    }

    public List<SIBLING> getSiblingsOut() {
        return siblingsOut;
    }

    public void setSiblingsOut(List<SIBLING> siblingsOut) {
        this.siblingsOut = siblingsOut;
    }

    public List<COUSIN> getCousinsOut() {
        return cousinsOut;
    }

    public void setCousinsOut(List<COUSIN> cousinsOut) {
        this.cousinsOut = cousinsOut;
    }

    public void setSiblings(List<SIBLING> siblings) {
        this.siblings = siblings;
    }

    public List<COUSIN> getCousins() {
        return cousins;
    }

    public void setCousins(List<COUSIN> cousins) {
        this.cousins = cousins;
    }

    public List<BLIZKIE_RODS> getBlizkieRods() {
        return blizkieRods;
    }

    public void setBlizkieRods(List<BLIZKIE_RODS> blizkieRods) {
        this.blizkieRods = blizkieRods;
    }

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

    @Relationship(type = "ESF_5and10", direction = Relationship.Direction.INCOMING)
    private List<ESF_5and10> esf5and10s;
    @Relationship(type = "ESF_5and10", direction = Relationship.Direction.OUTGOING)
    private List<ESF_5and10> esf5and10sOut;

    @Relationship(type = "FOUNDER_CUR", direction = Relationship.Direction.INCOMING)
    private List<FOUNDER_CUR> founderCurs;

    @Relationship(type = "FOUNDER_HIST", direction = Relationship.Direction.INCOMING)
    private List<FOUNDER_HIST> founderHists;


    public List<FOUNDER_HIST> getFounderHists() {
        return founderHists;
    }

    public void setFounderHists(List<FOUNDER_HIST> founderHists) {
        this.founderHists = founderHists;
    }

    @Relationship(type = "NTR_FL", direction = Relationship.Direction.OUTGOING)
    private List<NTR_FL> ntrFls;

    @Relationship(type = "OPG", direction = Relationship.Direction.OUTGOING)
    private List<OPG> opgs;

    @Relationship(type = "PDL", direction = Relationship.Direction.OUTGOING)
    private List<PDL> pdls;

    @Relationship(type = "REG_ADDRESS", direction = Relationship.Direction.OUTGOING)
    private List<REG_ADDRESS> regAddresses;

    @Relationship(type = "REG_ADDRESS_CUR", direction = Relationship.Direction.OUTGOING)
    private List<REG_ADDRESS_CUR> regAddressCurs;

    @Relationship(type = "REG_ADDRESS_HIST", direction = Relationship.Direction.OUTGOING)
    private List<REG_ADDRESS_HIST> regAddressHists;

    @Relationship(type = "SLUZHIL", direction = Relationship.Direction.OUTGOING)
    private List<SLUZHIL> sluzhils;

    @Relationship(type = "SUDIM", direction = Relationship.Direction.OUTGOING)
    private List<SUDIM> sudims;

    @Relationship(type = "ZAGS", direction = Relationship.Direction.OUTGOING)
    private List<ZAGS> zags;

    @Relationship(type = "ZAGS_FIO", direction = Relationship.Direction.OUTGOING)
    private List<ZAGS_FIO> zagsFios;

    @Relationship(type = "ZAGS_IIN", direction = Relationship.Direction.OUTGOING)
    private List<ZAGS_IIN> zagsIins;

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

    public List<DFO_AFF_FIZ> getDfoAffFizs() {
        return dfoAffFizs;
    }

    public void setDfoAffFizs(List<DFO_AFF_FIZ> dfoAffFizs) {
        this.dfoAffFizs = dfoAffFizs;
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

    public List<NTR_FL> getNtrFls() {
        return ntrFls;
    }

    public void setNtrFls(List<NTR_FL> ntrFls) {
        this.ntrFls = ntrFls;
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

    public List<REG_ADDRESS_CUR> getRegAddressCurs() {
        return regAddressCurs;
    }

    public void setRegAddressCurs(List<REG_ADDRESS_CUR> regAddressCurs) {
        this.regAddressCurs = regAddressCurs;
    }

    public List<REG_ADDRESS_HIST> getRegAddressHists() {
        return regAddressHists;
    }

    public void setRegAddressHists(List<REG_ADDRESS_HIST> regAddressHists) {
        this.regAddressHists = regAddressHists;
    }

    public List<SLUZHIL> getSluzhils() {
        return sluzhils;
    }

    public void setSluzhils(List<SLUZHIL> sluzhils) {
        this.sluzhils = sluzhils;
    }

    public List<SUDIM> getSudims() {
        return sudims;
    }

    public void setSudims(List<SUDIM> sudims) {
        this.sudims = sudims;
    }

    public List<ZAGS> getZags() {
        return zags;
    }

    public void setZags(List<ZAGS> zags) {
        this.zags = zags;
    }

    public List<ZAGS_FIO> getZagsFios() {
        return zagsFios;
    }

    public void setZagsFios(List<ZAGS_FIO> zagsFios) {
        this.zagsFios = zagsFios;
    }

    public List<ZAGS_IIN> getZagsIins() {
        return zagsIins;
    }

    public void setZagsIins(List<ZAGS_IIN> zagsIins) {
        this.zagsIins = zagsIins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public String getData_Rozhdenya() {
        return Data_Rozhdenya;
    }

    public void setData_Rozhdenya(String data_Rozhdenya) {
        Data_Rozhdenya = data_Rozhdenya;
    }

    public String getFamilia() {
        return Familia;
    }

    public void setFamilia(String familia) {
        Familia = familia;
    }

    public String getOtchestvo() {
        return Otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        Otchestvo = otchestvo;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }

    public String getDeath_Status() {
        return Death_Status;
    }

    public void setDeath_Status(String death_Status) {
        Death_Status = death_Status;
    }

    public String getMed_org() {
        return Med_org;
    }

    public void setMed_org(String med_org) {
        Med_org = med_org;
    }

    public String getStatus_Minzdrav() {
        return Status_Minzdrav;
    }

    public void setStatus_Minzdrav(String status_Minzdrav) {
        Status_Minzdrav = status_Minzdrav;
    }

    public String getStatus_KUIS() {
        return Status_KUIS;
    }

    public void setStatus_KUIS(String status_KUIS) {
        Status_KUIS = status_KUIS;
    }

    public String getPristavanie() {
        return Pristavanie;
    }

    public void setPristavanie(String pristavanie) {
        Pristavanie = pristavanie;
    }

    public String getData_reshenya() {
        return Data_reshenya;
    }

    public void setData_reshenya(String data_reshenya) {
        Data_reshenya = data_reshenya;
    }

    public String getRazmer_Shtrafa() {
        return Razmer_Shtrafa;
    }

    public void setRazmer_Shtrafa(String razmer_Shtrafa) {
        Razmer_Shtrafa = razmer_Shtrafa;
    }

    public String getOrgan_pravanarushenya() {
        return Organ_pravanarushenya;
    }

    public void setOrgan_pravanarushenya(String organ_pravanarushenya) {
        Organ_pravanarushenya = organ_pravanarushenya;
    }

    public String getStatya() {
        return Statya;
    }

    public void setStatya(String statya) {
        Statya = statya;
    }

    public String getPFR_Info() {
        return PFR_Info;
    }

    public void setPFR_Info(String PFR_Info) {
        this.PFR_Info = PFR_Info;
    }

    public String getAutditor() {
        return Autditor;
    }

    public void setAutditor(String autditor) {
        Autditor = autditor;
    }

    public String getNotarius() {
        return Notarius;
    }

    public void setNotarius(String notarius) {
        Notarius = notarius;
    }

    public String getAdvocat() {
        return Advocat;
    }

    public void setAdvocat(String advocat) {
        Advocat = advocat;
    }

    public String getSud_ispolnitel() {
        return Sud_ispolnitel;
    }

    public void setSud_ispolnitel(String sud_ispolnitel) {
        Sud_ispolnitel = sud_ispolnitel;
    }

    public String getGLK() {
        return GLK;
    }

    public void setGLK(String GLK) {
        this.GLK = GLK;
    }

    public String getPropal() {
        return Propal;
    }

    public void setPropal(String propal) {
        Propal = propal;
    }

    public String getDate_of_Death() {
        return Date_of_Death;
    }

    public void setDate_of_Death(String date_of_Death) {
        Date_of_Death = date_of_Death;
    }

    public String getRIP_date() {
        return RIP_date;
    }

    public void setRIP_date(String RIP_date) {
        this.RIP_date = RIP_date;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", PersonID='" + PersonID + '\'' +
                ", Data_Rozhdenya='" + Data_Rozhdenya + '\'' +
                ", Familia='" + Familia + '\'' +
                ", Otchestvo='" + Otchestvo + '\'' +
                ", FIO='" + FIO + '\'' +
                ", Source='" + Source + '\'' +
                ", Label='" + Label + '\'' +
                ", IIN='" + IIN + '\'' +
                ", Death_Status='" + Death_Status + '\'' +
                ", Med_org='" + Med_org + '\'' +
                ", Status_Minzdrav='" + Status_Minzdrav + '\'' +
                ", Status_KUIS='" + Status_KUIS + '\'' +
                ", Pristavanie='" + Pristavanie + '\'' +
                ", Data_reshenya='" + Data_reshenya + '\'' +
                ", Razmer_Shtrafa='" + Razmer_Shtrafa + '\'' +
                ", Organ_pravanarushenya='" + Organ_pravanarushenya + '\'' +
                ", Statya='" + Statya + '\'' +
                ", PFR_Info='" + PFR_Info + '\'' +
                ", Autditor='" + Autditor + '\'' +
                ", Notarius='" + Notarius + '\'' +
                ", Advocat='" + Advocat + '\'' +
                ", Sud_ispolnitel='" + Sud_ispolnitel + '\'' +
                ", GLK='" + GLK + '\'' +
                ", Propal='" + Propal + '\'' +
                ", Date_of_Death='" + Date_of_Death + '\'' +
                ", RIP_date='" + RIP_date + '\'' +
//                ", regAddress=" + regAddress +
                '}';
    }
}
