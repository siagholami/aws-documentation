# Text Processing in Amazon CloudSearch<a name="text-processing"></a>

During indexing, Amazon CloudSearch processes `text` and `text-array` fields according to the analysis scheme configured for the field to determine what terms to add to the index\. Before the analysis options are applied, the text is *tokenized* and *normalized*\. 

During tokenization, the stream of text in a field is split into separate tokens on detectable boundaries using the word break rules defined in the Unicode Text Segmentation algorithm\. For more information, see [Unicode Text Segmentation](http://www.unicode.org/reports/tr29/)\. 

According to the word break rules, strings separated by whitespace such as spaces and tabs are treated as separate tokens\. In many cases, punctuation is dropped and treated as whitespace\. For example, strings are split at hyphens \(\-\) and the at symbol \(@\)\. However, periods that are not followed by whitespace are considered part of the token\. 

Note that strings are not split on case boundaries—*CamelCase* strings are not tokenized\. 

During normalization, upper case characters are converted to lower case\. Accents are typically handled according to the stemming options configured in the field's analysis scheme\. \(The default analysis scheme for English removes accents\.\) 

Once tokenization and normalization are complete, the stemming options, stopwords, and synonyms specified in the analysis scheme are applied\. 

When you submit a search request, the text you're searching for undergoes the same text processing so that it can be matched against the terms that appear in the index\. However, no text analysis is performed on the search term when you perform a prefix search\. This means that a search for a prefix that ends in `s` typically won't match the singular version of the term when stemming is enabled\. This can happen for any term that ends in `s`, not just plurals\. For example, if you search the `actor` field in the sample movie data for `Anders`, there are three matching movies\. If you search for `Ander*`, you get those movies as well as several others\. However, if you search for `Anders*` there are no matches\. This is because the term is stored in the index as `ander`, `anders` does not appear in the index\.

 If stemming is preventing your wildcard searches from returning all of the relevant matches, you can suppress stemming for the text field by setting the `AlgorithmicStemming` option to none, or you can map the data to a `literal` field instead of a `text` field\. 

**Topics**
+ [Supported Languages in Amazon CloudSearch](supported-languages.md)
+ [Language Specific Text Processing Settings in Amazon CloudSearch](#text-processing-settings)

## Language Specific Text Processing Settings in Amazon CloudSearch<a name="text-processing-settings"></a>

### Arabic \(ar\)<a name="arabic"></a>

Algorithmic stemming options: `light`

Default analysis scheme: `_ar_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  من ومن منها منه في وفي فيها فيه و ف ثم او أو ب بها به ا أ اى اي أي أى لا ولا الا ألا إلا لكن ما وما كما فما عن مع اذا إذا ان أن إن انها أنها إنها انه أنه إنه بان بأن فان فأن وان وأن وإن التى التي الذى الذي الذين الى الي إلى إلي على عليها عليه اما أما إما ايضا أيضا كل وكل لم ولم لن ولن هى هي هو وهى وهي وهو فهى فهي فهو انت أنت لك لها له هذه هذا تلك ذلك هناك كانت كان يكون تكون وكانت وكان غير بعض قد نحو بين بينما منذ ضمن حيث الان الآن خلال بعد قبل حتى عند عندما لدى جميع

### Armenian \(hy\)<a name="armenian"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_hy_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  այդ այլ այն այս դու դուք եմ են ենք ես եք է էի էին էինք էիր էիք էր ըստ թ ի ին իսկ իր կամ համար հետ հետո մենք մեջ մի ն նա նաև նրա նրանք որ որը որոնք որպես ու ում պիտի վրա և

### Basque \(eu\)<a name="basque"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_eu_default_`
+ Algorithmic stemming options: `full`
+ Default stopword dictionary:

  al anitz arabera asko baina bat batean batek bati batzuei batzuek batzuetan batzuk bera beraiek berau berauek bere berori beroriek beste bezala da dago dira ditu du dute edo egin ere eta eurak ez gainera gu gutxi guzti haiei haiek haietan hainbeste hala han handik hango hara hari hark hartan hau hauei hauek hauetan hemen hemendik hemengo hi hona honek honela honetan honi hor hori horiei horiek horietan horko horra horrek horrela horretan horri hortik hura izan ni noiz nola non nondik nongo nor nora ze zein zen zenbait zenbat zer zergatik ziren zituen zu zuek zuen zuten

### Bulgarian \(bg\)<a name="bulgarian"></a>

Algorithmic stemming options: `light`

Default analysis scheme: `_bg_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  а аз ако ала бе без беше би бил била били било близо бъдат бъде бяха в вас ваш ваша вероятно вече взема ви вие винаги все всеки всички всичко всяка във въпреки върху г ги главно го д да дали до докато докога дори досега доста е едва един ето за зад заедно заради засега затова защо защото и из или им има имат иска й каза как каква какво както какъв като кога когато което които кой който колко която къде където към ли м ме между мен ми мнозина мога могат може моля момента му н на над назад най направи напред например нас не него нея ни ние никой нито но някои някой няма обаче около освен особено от отгоре отново още пак по повече повечето под поне поради после почти прави пред преди през при пък първо с са само се сега си скоро след сме според сред срещу сте съм със също т тази така такива такъв там твой те тези ти тн то това тогава този той толкова точно трябва тук тъй тя тях у харесва ч че често чрез ще щом я

### Catalan \(ca\)<a name="catalan"></a>

Algorithmic stemming options: `full`

Elision filter enabled

Default analysis scheme: `_ca_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  a abans ací ah així això al als aleshores algun alguna algunes alguns alhora allà allí allò altra altre altres amb ambdós ambdues apa aquell aquella aquelles aquells aquest aquesta aquestes aquests aquí baix cada cadascú cadascuna cadascunes cadascuns com contra d'un d'una d'unes d'uns dalt de del dels des després dins dintre donat doncs durant e eh el els em en encara ens entre érem eren éreu es és esta està estàvem estaven estàveu esteu et etc ets fins fora gairebé ha han has havia he hem heu hi ho i igual iguals ja l'hi la les li li'n llavors m'he ma mal malgrat mateix mateixa mateixes mateixos me mentre més meu meus meva meves molt molta moltes molts mon mons n'he n'hi ne ni no nogensmenys només nosaltres nostra nostre nostres o oh oi on pas pel pels per però perquè poc poca pocs poques potser propi qual quals quan quant que què quelcom qui quin quina quines quins s'ha s'han sa semblant semblants ses seu seus seva seva seves si sobre sobretot sóc solament sols son són sons sota sou t'ha t'han t'he ta tal també tampoc tan tant tanta tantes teu teus teva teves ton tons tot tota totes tots un una unes uns us va vaig vam van vas veu vosaltres vostra vostre vostres

### Chinese \- Simplified \(zh\-Hans\)<a name="chinese-simplified"></a>

Algorithmic stemming not supported

Stemming dictionary not supported

Default analysis scheme: `_zh-Hans_default_`

### Chinese \- Traditional \(zh\-Hant\)<a name="chinese-traditional"></a>

Algorithmic stemming not supported

Stemming dictionary not supported

Default analysis scheme: `_zh-Hant_default_`

### Czech \(cz\)<a name="czech"></a>

Algorithmic stemming options: `light`

Default analysis scheme: `_cs_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  a s k o i u v z dnes cz tímto budeš budem byli jseš můj svým ta tomto tohle tuto tyto jej zda proč máte tato kam tohoto kdo kteří mi nám tom tomuto mít nic proto kterou byla toho protože asi ho naši napište re což tím takže svých její svými jste aj tu tedy teto bylo kde ke pravé ji nad nejsou či pod téma mezi přes ty pak vám ani když však neg jsem tento článku články aby jsme před pta jejich byl ještě až bez také pouze první vaše která nás nový tipy pokud může strana jeho své jiné zprávy nové není vás jen podle zde už být více bude již než který by které co nebo ten tak má při od po jsou jak další ale si se ve to jako za zpět ze do pro je na atd atp jakmile přičemž já on ona ono oni ony my vy jí ji mě mne jemu tomu těm těmu němu němuž jehož jíž jelikož jež jakož načež

### Danish \(da\)<a name="danish"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_da_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  og i jeg det at en den til er som på de med han af for ikke der var mig sig men et har om vi min havde ham hun nu over da fra du ud sin dem os op man hans hvor eller hvad skal selv her alle vil blev kunne ind når være dog noget ville jo deres efter ned skulle denne end dette mit også under have dig anden hende mine alt meget sit sine vor mod disse hvis din nogle hos blive mange ad bliver hendes været thi jer sådan

### Dutch \(nl\)<a name="dutch"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_nl_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  de en van ik te dat die in een hij het niet zijn is was op aan met als voor had er maar om hem dan zou of wat mijn men dit zo door over ze zich bij ook tot je mij uit der daar haar naar heb hoe heeft hebben deze u want nog zal me zij nu ge geen omdat iets worden toch al waren veel meer doen toen moet ben zonder kan hun dus alles onder ja eens hier wie werd altijd doch wordt wezen kunnen ons zelf tegen na reeds wil kon niets uw iemand geweest andere
+ Default stemming dictionary:

  fiets fiets bromfiets bromfiets ei eier kind kinder 

### English \(en\)<a name="english"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_en_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  a an and are as at be but by for if in into is it no not of on or such that the their then there these they this to was will with

### Finnish \(fi\)<a name="finnish"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_fi_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  olla olen olet on olemme olette ovat ole oli olisi olisit olisin olisimme olisitte olisivat olit olin olimme olitte olivat ollut olleet en et ei emme ette eivät minä minun minut minua minussa minusta minuun minulla minulta minulle sinä sinun sinut sinua sinussa sinusta sinuun sinulla sinulta sinulle hän hänen hänet häntä hänessä hänestä häneen hänellä häneltä hänelle me meidän meidät meitä meissä meistä meihin meillä meiltä meille te teidän teidät teitä teissä teistä teihin teillä teiltä teille he heidän heidät heitä heissä heistä heihin heillä heiltä heille tämä tämän tätä tässä tästä tähän tallä tältä tälle tänä täksi tuo tuon tuotä tuossa tuosta tuohon tuolla tuolta tuolle tuona tuoksi se sen sitä siinä siitä siihen sillä siltä sille sinä siksi nämä näiden näitä näissä näistä näihin näillä näiltä näille näinä näiksi nuo noiden noita noissa noista noihin noilla noilta noille noina noiksi ne niiden niitä niissä niistä niihin niillä niiltä niille niinä niiksi kuka kenen kenet ketä kenessä kenestä keneen kenellä keneltä kenelle kenenä keneksi ketkä keiden ketkä keitä keissä keistä keihin keillä keiltä keille keinä keiksi mikä minkä minkä mitä missä mistä mihin millä miltä mille minä miksi mitkä joka jonka jota jossa josta johon jolla jolta jolle jona joksi jotka joiden joita joissa joista joihin joilla joilta joille joina joiksi että ja jos koska kuin mutta niin sekä sillä tai vaan vai vaikka kanssa mukaan noin poikki yli kun niin nyt itse

### French \(fr\)<a name="french"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Elision filter enabled

Default analysis scheme: `_fr_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  au aux avec ce ces dans de des du elle en et eux il je la le leur lui ma mais me même mes moi mon ne nos notre nous on ou par pas pour qu que qui sa se ses son sur ta te tes toi ton tu un une vos votre vous c d j l à m n s t y été étée étées étés étant suis es est sommes êtes sont serai seras sera serons serez seront serais serait serions seriez seraient étais était étions étiez étaient fus fut fûmes fûtes furent sois soit soyons soyez soient fusse fusses fût fussions fussiez fussent ayant eu eue eues eus ai as avons avez ont aurai auras aura aurons aurez auront aurais aurait aurions auriez auraient avais avait avions aviez avaient eut eûmes eûtes eurent aie aies ait ayons ayez aient eusse eusses eût eussions eussiez eussent ceci celà  cet cette ici ils les leurs quel quels quelle quelles sans soi

### Galician \(gl\)<a name="galician"></a>

Algorithmic stemming options: `minimal`\|`full`

Default analysis scheme: `_gl_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  \# galican stopwords a aínda alí aquel aquela aquelas aqueles aquilo aquí ao aos as así á ben cando che co coa comigo con connosco contigo convosco coas cos cun cuns cunha cunhas da dalgunha dalgunhas dalgún dalgúns das de del dela delas deles desde deste do dos dun duns dunha dunhas e el ela elas eles en era eran esa esas ese eses esta estar estaba está están este estes estiven estou eu é facer foi foron fun había hai iso isto la las lle lles lo los mais me meu meus min miña miñas moi na nas neste nin no non nos nosa nosas noso nosos nós nun nunha nuns nunhas o os ou ó ós para pero pode pois pola polas polo polos por que se senón ser seu seus sexa sido sobre súa súas tamén tan te ten teñen teño ter teu teus ti tido tiña tiven túa túas un unha unhas uns vos vosa vosas voso vosos vós 

### German \(de\)<a name="german"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_de_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  aber alle allem allen aller alles als also am an ander andere anderem anderen anderer anderes anderm andern anderr anders auch auf aus bei bin bis bist da damit dann der den des dem die das daß derselbe derselben denselben desselben demselben dieselbe dieselben dasselbe dazu dein deine deinem deinen deiner deines denn derer dessen dich dir du dies diese diesem diesen dieser dieses doch dort durch ein eine einem einen einer eines einig einige einigem einigen einiger einiges einmal er ihn ihm es etwas euer eure eurem euren eurer eures für gegen gewesen hab habe haben hat hatte hatten hier hin hinter ich mich mir ihr ihre ihrem ihren ihrer ihres euch im in indem ins ist jede jedem jeden jeder jedes jene jenem jenen jener jenes jetzt kann kein keine keinem keinen keiner keines können könnte machen man manche manchem manchen mancher manches mein meine meinem meinen meiner meines mit muss musste nach nicht nichts noch nun nur ob oder ohne sehr sein seine seinem seinen seiner seines selbst sich sie ihnen sind so solche solchem solchen solcher solches soll sollte sondern sonst über um und uns unse unsem unsen unser unses unter viel vom von vor während war waren warst was weg weil weiter welche welchem welchen welcher welches wenn werde werden wie wieder will wir wird wirst wo wollen wollte würde würden zu zum zur zwar zwischen

### Greek \(el\)<a name="greek"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_el_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  ο η το οι τα του τησ των τον την και κι κ ειμαι εισαι ειναι ειμαστε ειστε στο στον στη στην μα αλλα απο για προσ με σε ωσ παρα αντι κατα μετα θα να δε δεν μη μην επι ενω εαν αν τοτε που πωσ ποιοσ ποια ποιο ποιοι ποιεσ ποιων ποιουσ αυτοσ αυτη αυτο αυτοι αυτων αυτουσ αυτεσ αυτα εκεινοσ εκεινη εκεινο εκεινοι εκεινεσ εκεινα εκεινων εκεινουσ οπωσ ομωσ ισωσ οσο οτι

### Hebrew \(h3\)<a name="hebrew"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_he_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary

### Hindi \(hi\)<a name="hindi"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_hi_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary

### Hungarian \(hu\)<a name="hungarian"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_hu_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  a ahogy ahol aki akik akkor alatt által általában amely amelyek amelyekben amelyeket amelyet amelynek ami amit amolyan amíg amikor át abban ahhoz annak arra arról az azok azon azt azzal azért aztán azután azonban bár be belül benne cikk cikkek cikkeket csak de e eddig egész egy egyes egyetlen egyéb egyik egyre ekkor el elég ellen elő először előtt első én éppen ebben ehhez emilyen ennek erre ez ezt ezek ezen ezzel ezért és fel felé hanem hiszen hogy hogyan igen így illetve ill\. ill ilyen ilyenkor ison ismét itt jó jól jobban kell kellett keresztül keressünk ki kívül között közül legalább lehet lehetett legyen lenne lenni lesz lett maga magát majd majd már más másik meg még mellett mert mely melyek mi mit míg miért milyen mikor minden mindent mindenki mindig mint mintha mivel most nagy nagyobb nagyon ne néha nekem neki nem néhány nélkül nincs olyan ott össze ő ők őket pedig persze rá s saját sem semmi sok sokat sokkal számára szemben szerint szinte talán tehát teljes tovább továbbá több úgy ugyanis új újabb újra után utána utolsó vagy vagyis valaki valami valamint való vagyok van vannak volt voltam voltak voltunk vissza vele viszont volna

### Indonesian \(id\)<a name="indonesian"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `id_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  ada adanya adalah adapun agak agaknya agar akan akankah akhirnya aku akulah amat amatlah anda andalah antar diantaranya antara antaranya diantara apa apaan mengapa apabila apakah apalagi apatah atau ataukah ataupun bagai bagaikan sebagai sebagainya bagaimana bagaimanapun sebagaimana bagaimanakah bagi bahkan bahwa bahwasanya sebaliknya banyak sebanyak beberapa seberapa begini beginian beginikah beginilah sebegini begitu begitukah begitulah begitupun sebegitu belum belumlah sebelum sebelumnya sebenarnya berapa berapakah berapalah berapapun betulkah sebetulnya biasa biasanya bila bilakah bisa bisakah sebisanya boleh bolehkah bolehlah buat bukan bukankah bukanlah bukannya cuma percuma dahulu dalam dan dapat dari daripada dekat demi demikian demikianlah sedemikian dengan depan di dia dialah dini diri dirinya terdiri dong dulu enggak enggaknya entah entahlah terhadap terhadapnya hal hampir hanya hanyalah harus haruslah harusnya seharusnya hendak hendaklah hendaknya hingga sehingga ia ialah ibarat ingin inginkah inginkan ini inikah inilah itu itukah itulah jangan jangankan janganlah jika jikalau juga justru kala kalau kalaulah kalaupun kalian kami kamilah kamu kamulah kan kapan kapankah kapanpun dikarenakan karena karenanya ke kecil kemudian kenapa kepada kepadanya ketika seketika khususnya kini kinilah kiranya sekiranya kita kitalah kok lagi lagian selagi lah lain lainnya melainkan selaku lalu melalui terlalu lama lamanya selama selama selamanya lebih terlebih bermacam macam semacam maka makanya makin malah malahan mampu mampukah mana manakala manalagi masih masihkah semasih masing mau maupun semaunya memang mereka merekalah meski meskipun semula mungkin mungkinkah nah namun nanti nantinya nyaris oleh olehnya seorang seseorang pada padanya padahal paling sepanjang pantas sepantasnya sepantasnyalah para pasti pastilah per pernah pula pun merupakan rupanya serupa saat saatnya sesaat saja sajalah saling bersama sama sesama sambil sampai sana sangat sangatlah saya sayalah se sebab sebabnya sebuah tersebut tersebutlah sedang sedangkan sedikit sedikitnya segala segalanya segera sesegera sejak sejenak sekali sekalian sekalipun sesekali sekaligus sekarang sekarang sekitar sekitarnya sela selain selalu seluruh seluruhnya semakin sementara sempat semua semuanya sendiri sendirinya seolah seperti sepertinya sering seringnya serta siapa siapakah siapapun disini disinilah sini sinilah sesuatu sesuatunya suatu sesudah sesudahnya sudah sudahkah sudahlah supaya tadi tadinya tak tanpa setelah telah tentang tentu tentulah tentunya tertentu seterusnya tapi tetapi setiap tiap setidaknya tidak tidakkah tidaklah toh waduh wah wahai sewaktu walau walaupun wong yaitu yakni yang

### Irish \(ga\)<a name="irish"></a>

Algorithmic stemming options: `full`

Elision filter enabled

Default analysis scheme: `_ga_default_`
+ Algorithmic stemming options: `full`
+ Default stopword dictionary:

  a ach ag agus an aon ar arna as b' ba beirt bhúr caoga ceathair ceathrar chomh chtó chuig chun cois céad cúig cúigear d' daichead dar de deich deichniúr den dhá do don dtí dá dár dó faoi faoin faoina faoinár fara fiche gach gan go gur haon hocht i iad idir in ina ins inár is le leis lena lenár m' mar mo mé na nach naoi naonúr ná ní níor nó nócha ocht ochtar os roimh sa seacht seachtar seachtó seasca seisear siad sibh sinn sna sé sí tar thar thú triúr trí trína trínár tríocha tú um ár é éis í ó ón óna ónár

### Italian \(it\)<a name="italian"></a>

Algorithmic stemming options: `light`\|`full`

Elision filter enabled

Default analysis scheme: `_it_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  ad al allo ai agli all agl alla alle con col coi da dal dallo dai dagli dall dagl dalla dalle di del dello dei degli dell degl della delle in nel nello nei negli nell negl nella nelle su sul sullo sui sugli sull sugl sulla sulle per tra contro io tu lui lei noi voi loro mio mia miei mie tuo tua tuoi tue suo sua suoi sue nostro nostra nostri nostre vostro vostra vostri vostre mi ti ci vi lo la li le gli ne il un uno una ma ed se perché anche come dov dove che chi cui non più quale quanto quanti quanta quante quello quelli quella quelle questo questi questa queste si tutto tutti a c e i l o ho hai ha abbiamo avete hanno abbia abbiate abbiano avrò avrai avrà avremo avrete avranno avrei avresti avrebbe avremmo avreste avrebbero avevo avevi aveva avevamo avevate avevano ebbi avesti ebbe avemmo aveste ebbero avessi avesse avessimo avessero avendo avuto avuta avuti avute sono sei è siamo siete sia siate siano sarò sarai sarà saremo sarete saranno sarei saresti sarebbe saremmo sareste sarebbero ero eri era eravamo eravate erano fui fosti fu fummo foste furono fossi fosse fossimo fossero essendo faccio fai facciamo fanno faccia facciate facciano farò farai farà faremo farete faranno farei faresti farebbe faremmo fareste farebbero facevo facevi faceva facevamo facevate facevano feci facesti fece facemmo faceste fecero facessi facesse facessimo facessero facendo sto stai sta stiamo stanno stia stiate stiano starò starai starà staremo starete staranno starei staresti starebbe staremmo stareste starebbero stavo stavi stava stavamo stavate stavano stetti stesti stette stemmo steste stettero stessi stesse stessimo stessero stando

### Japanese \(ja\)<a name="japanese"></a>

Algorithmic stemming options: `full`

Algorithmic decompounding enabled

Optional tokenization dictionary

Default analysis scheme: `_ja_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  の に は を た が で て と し れ さ ある いる も する から な こと として い や れる など なっ ない この ため その あっ よう また もの という あり まで られ なる へ か だ これ によって により おり より による ず なり られる において ば なかっ なく しかし について せ だっ その後 できる それ う ので なお のみ でき き つ における および いう さらに でも ら たり その他 に関する たち ます ん なら に対して 特に せる 及び これら とき では にて ほか ながら うち そして とともに ただし かつて それぞれ または お ほど ものの に対する ほとんど と共に といった です とも ところ ここ

### Korean \(ko\)<a name="korean"></a>

Algorithmic stemming not supported

Algorithmic decompounding enabled

Default analysis scheme: `_ko_default_`
+ Default stopword dictionary

### Latvian \(lv\)<a name="latvian"></a>

Algorithmic stemming: `light`

Default analysis scheme: `_lv_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  aiz ap ar apakš ārpus augšpus bez caur dēļ gar iekš iz kopš labad lejpus līdz no otrpus pa par pār pēc pie pirms pret priekš starp šaipus uz viņpus virs virspus zem apakšpus un bet jo ja ka lai tomēr tikko turpretī arī kaut gan tādēļ tā ne tikvien vien kā ir te vai kamēr ar diezin droši diemžēl nebūt ik it taču nu pat tiklab iekšpus nedz tik nevis turpretim jeb iekam iekām iekāms kolīdz līdzko tiklīdz jebšu tālab tāpēc nekā itin jā jau jel nē nezin tad tikai vis tak iekams vien būt biju biji bija bijām bijāt esmu esi esam esat būšu būsi būs būsim būsiet tikt tiku tiki tika tikām tikāt tieku tiec tiek tiekam tiekat tikšu tiks tiksim tiksiet tapt tapi tapāt topat tapšu tapsi taps tapsim tapsiet kļūt kļuvu kļuvi kļuva kļuvām kļuvāt kļūstu kļūsti kļūst kļūstam kļūstat kļūšu kļūsi kļūs kļūsim kļūsiet varēt varēju varējām varēšu varēsim var varēji varējāt varēsi varēsiet varat varēja varēs

### Multiple \(mul\)<a name="multiple"></a>

Algorithmic stemming: not supported

Default analysis scheme: `_mul_default_`
+ Default stopword dictionary

### Norwegian \(no\)<a name="norwegian"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_no_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  og i jeg det at en et den til er som på de med han av ikke ikkje der så var meg seg men ett har om vi min mitt ha hadde hun nå over da ved fra du ut sin dem oss opp man kan hans hvor eller hva skal selv sjøl her alle vil bli ble blei blitt kunne inn når være kom noen noe ville dere som deres kun ja etter ned skulle denne for deg si sine sitt mot å meget hvorfor dette disse uten hvordan ingen din ditt blir samme hvilken hvilke sånn inni mellom vår hver hvem vors hvis både bare enn fordi før mange også slik vært være båe begge siden dykk dykkar dei deira deires deim di då eg ein eit eitt elles honom hjå ho hoe henne hennar hennes hoss hossen ikkje ingi inkje korleis korso kva kvar kvarhelst kven kvi kvifor me medan mi mine mykje no nokon noka nokor noko nokre si sia sidan so somt somme um upp vere vore verte vort varte vart

### Persian \(fa\)<a name="persian"></a>

Algorithmic stemming not supported

Default analysis scheme: `_fa_default_`
+ Default stopword dictionary:

  انان نداشته سراسر خياه ايشان وي تاكنون بيشتري دوم پس ناشي وگو يا داشتند سپس هنگام هرگز پنج نشان امسال ديگر گروهي شدند چطور ده و دو نخستين ولي چرا چه وسط ه كدام قابل يك رفت هفت همچنين در هزار بله بلي شايد اما شناسي گرفته دهد داشته دانست داشتن خواهيم ميليارد وقتيكه امد خواهد جز اورده شده بلكه خدمات شدن برخي نبود بسياري جلوگيري حق كردند نوعي بعري نكرده نظير نبايد بوده بودن داد اورد هست جايي شود دنبال داده بايد سابق هيچ همان انجا كمتر كجاست گردد كسي تر مردم تان دادن بودند سري جدا ندارند مگر يكديگر دارد دهند بنابراين هنگامي سمت جا انچه خود دادند زياد دارند اثر بدون بهترين بيشتر البته به براساس بيرون كرد بعضي گرفت توي اي ميليون او جريان تول بر مانند برابر باشيم مدتي گويند اكنون تا تنها جديد چند بي نشده كردن كردم گويد كرده كنيم نمي نزد روي قصد فقط بالاي ديگران اين ديروز توسط سوم ايم دانند سوي استفاده شما كنار داريم ساخته طور امده رفته نخست بيست نزديك طي كنيد از انها تمامي داشت يكي طريق اش چيست روب نمايد گفت چندين چيزي تواند ام ايا با ان ايد ترين اينكه ديگري راه هايي بروز همچنان پاعين كس حدود مختلف مقابل چيز گيرد ندارد ضد همچون سازي شان مورد باره مرسي خويش برخوردار چون خارج شش هنوز تحت ضمن هستيم گفته فكر بسيار پيش براي روزهاي انكه نخواهد بالا كل وقتي كي چنين كه گيري نيست است كجا كند نيز يابد بندي حتي توانند عقب خواست كنند بين تمام همه ما باشند مثل شد اري باشد اره طبق بعد اگر صورت غير جاي بيش ريزي اند زيرا چگونه بار لطفا مي درباره من ديده همين گذاري برداري علت گذاشته هم فوق نه ها شوند اباد همواره هر اول خواهند چهار نام امروز مان هاي قبل كنم سعي تازه را هستند زير جلوي عنوان بود

### Portuguese \(pt\)<a name="portuguese"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_pt_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  de a o que e do da em um para com não uma os no se na por mais as dos como mas ao ele das à seu sua ou quando muito nos já eu também só pelo pela até isso ela entre depois sem mesmo aos seus quem nas me esse eles você essa num nem suas meu às minha numa pelos elas qual nós lhe deles essas esses pelas este dele tu te vocês vos lhes meus minhas teu tua teus tuas nosso nossa nossos nossas dela delas esta estes estas aquele aquela aqueles aquelas isto aquilo estou está estamos estão estive esteve estivemos estiveram estava estávamos estavam estivera estivéramos esteja estejamos estejam estivesse estivéssemos estivessem estiver estivermos estiverem hei há havemos hão houve houvemos houveram houvera houvéramos haja hajamos hajam houvesse houvéssemos houvessem houver houvermos houverem houverei houverá houveremos houverão houveria houveríamos houveriam sou somos são era éramos eram fui foi fomos foram fora fôramos seja sejamos sejam fosse fôssemos fossem for formos forem serei será seremos serão seria seríamos seriam tenho tem temos tém tinha tínhamos tinham tive teve tivemos tiveram tivera tivéramos tenha tenhamos tenham tivesse tivéssemos tivessem tiver tivermos tiverem terei terá teremos terão teria teríamos teriam

### Romanian \(ro\)<a name="romanian"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_ro_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  acea aceasta această aceea acei aceia acel acela acele acelea acest acesta aceste acestea aceşti aceştia acolo acum ai aia aibă aici al ăla ale alea ălea altceva altcineva am ar are aş aşadar asemenea asta ăsta astăzi astea ăstea ăştia asupra aţi au avea avem aveţi azi bine bucur bună ca că căci când care cărei căror cărui cât câte câţi către câtva ce cel ceva chiar cînd cine cineva cît cîte cîţi cîtva contra cu cum cumva curând curînd da dă dacă dar datorită de deci deja deoarece departe deşi din dinaintea dintr dintre drept după ea ei el ele eram este eşti eu face fără fi fie fiecare fii fim fiţi iar ieri îi îl îmi împotriva în înainte înaintea încât încît încotro între întrucât întrucît îţi la lângă le li lîngă lor lui mă mâine mea mei mele mereu meu mi mine mult multă mulţi ne nicăieri nici nimeni nişte noastră noastre noi noştri nostru nu ori oricând oricare oricât orice oricînd oricine oricît oricum oriunde până pe pentru peste pînă poate pot prea prima primul prin printr sa să săi sale sau său se şi sînt sîntem sînteţi spre sub sunt suntem sunteţi ta tăi tale tău te ţi ţie tine toată toate tot toţi totuşi tu un una unde undeva unei unele uneori unor vă vi voastră voastre voi voştri vostru vouă vreo vreun

### Russian \(ru\)<a name="russian"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_ru_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  и в во не что он на я с со как а то все она так его но да ты к у же вы за бы по только ее мне было вот от меня еще нет о из ему теперь когда даже ну вдруг ли если уже или ни быть был него до вас нибудь опять уж вам сказал ведь там потом себя ничего ей может они тут где есть надо ней для мы тебя их чем была сам чтоб без будто человек чего раз тоже себе под жизнь будет ж тогда кто этот говорил того потому этого какой совсем ним здесь этом один почти мой тем чтобы нее кажется сейчас были куда зачем сказать всех никогда сегодня можно при наконец два об другой хоть после над больше тот через эти нас про всего них какая много разве сказала три эту моя впрочем хорошо свою этой перед иногда лучше чуть том нельзя такой им более всегда конечно всю между

### Spanish \(es\)<a name="spanish"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_es_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  de la que el en y a los del se las por un para con no una su al lo como más pero sus le ya o este sí porque esta entre cuando muy sin sobre también me hasta hay donde quien desde todo nos durante todos uno les ni contra otros ese eso ante ellos e esto mí antes algunos qué unos yo otro otras otra él tanto esa estos mucho quienes nada muchos cual poco ella estar estas algunas algo nosotros mi mis tú te ti tu tus ellas nosotras vosotros vosotras os mío mía míos mías tuyo tuya tuyos tuyas suyo suya suyos suyas nuestro nuestra nuestros nuestras vuestro vuestra vuestros vuestras esos esas estoy estás está estamos estáis están esté estés estemos estéis estén estaré estarás estará estaremos estaréis estarán estaría estarías estaríamos estaríais estarían estaba estabas estábamos estabais estaban estuve estuviste estuvo estuvimos estuvisteis estuvieron estuviera estuvieras estuviéramos estuvierais estuvieran estuviese estuvieses estuviésemos estuvieseis estuviesen estando estado estada estados estadas estad he has ha hemos habéis han haya hayas hayamos hayáis hayan habré habrás habrá habremos habréis habrán habría habrías habríamos habríais habrían había habías habíamos habíais habían hube hubiste hubo hubimos hubisteis hubieron hubiera hubieras hubiéramos hubierais hubieran hubiese hubieses hubiésemos hubieseis hubiesen habiendo habido habida habidos habidas soy eres es somos sois son sea seas seamos seáis sean seré serás será seremos seréis serán sería serías seríamos seríais serían era eras éramos erais eran fui fuiste fue fuimos fuisteis fueron fuera fueras fuéramos fuerais fueran fuese fueses fuésemos fueseis fuesen siendo sido tengo tienes tiene tenemos tenéis tienen tenga tengas tengamos tengáis tengan tendré tendrás tendrá tendremos tendréis tendrán tendría tendrías tendríamos tendríais tendrían tenía tenías teníamos teníais tenían tuve tuviste tuvo tuvimos tuvisteis tuvieron tuviera tuvieras tuviéramos tuvierais tuvieran tuviese tuvieses tuviésemos tuvieseis tuviesen teniendo tenido tenida tenidos tenidas tened

### Swedish \(sv\)<a name="swedish"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_sv_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  och det att i en jag hon som han på den med var sig för så till är men ett om hade de av icke mig du henne då sin nu har inte hans honom skulle hennes där min man ej vid kunde något från ut när efter upp vi dem vara vad över än dig kan sina här ha mot alla under någon eller allt mycket sedan ju denna själv detta åt utan varit hur ingen mitt ni bli blev oss din dessa några deras blir mina samma vilken er sådan vår blivit dess inom mellan sådant varför varje vilka ditt vem vilket sitta sådana vart dina vars vårt våra ert era vilkas

### Thai \(th\)<a name="thai"></a>

Algorithmic stemming not supported

Stemming dictionary not supported

Default analysis scheme: `_th_default_`
+ Default stopword dictionary:

  ไว้ ไม่ ไป ได้ ให้ ใน โดย แห่ง แล้ว และ แรก แบบ แต่ เอง เห็น เลย เริ่ม เรา เมื่อ เพื่อ เพราะ เป็นการ เป็น เปิดเผย เปิด เนื่องจาก เดียวกัน เดียว เช่น เฉพาะ เคย เข้า เขา อีก อาจ อะไร ออก อย่าง อยู่ อยาก หาก หลาย หลังจาก หลัง หรือ หนึ่ง ส่วน ส่ง สุด สําหรับ ว่า วัน ลง ร่วม ราย รับ ระหว่าง รวม ยัง มี มาก มา พร้อม พบ ผ่าน ผล บาง น่า นี้ นํา นั้น นัก นอกจาก ทุก ที่สุด ที่ ทําให้ ทํา ทาง ทั้งนี้ ทั้ง ถ้า ถูก ถึง ต้อง ต่างๆ ต่าง ต่อ ตาม ตั้งแต่ ตั้ง ด้าน ด้วย ดัง ซึ่ง ช่วง จึง จาก จัด จะ คือ ความ ครั้ง คง ขึ้น ของ ขอ ขณะ ก่อน ก็ การ กับ กัน กว่า กล่าว

### Turkish \(tr\)<a name="turkish"></a>

Algorithmic stemming: `full`

Default analysis scheme: `_tr_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary