# Text Processing in Amazon CloudSearch<a name="text-processing"></a>

During indexing, Amazon CloudSearch processes `text` and `text-array` fields according to the analysis scheme configured for the field to determine what terms to add to the index\. Before the analysis options are applied, the text is *tokenized* and *normalized*\. 

During tokenization, the stream of text in a field is split into separate tokens on detectable boundaries using the word break rules defined in the Unicode Text Segmentation algorithm\. For more information, see [Unicode Text Segmentation](http://www.unicode.org/reports/tr29/)\. 

According to the word break rules, strings separated by whitespace such as spaces and tabs are treated as separate tokens\. In many cases, punctuation is dropped and treated as whitespace\. For example, strings are split at hyphens \(\-\) and the at symbol \(@\)\. However, periods that are not followed by whitespace are considered part of the token\. 

Note that strings are not split on case boundariesâ€”*CamelCase* strings are not tokenized\. 

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

  Ů…Ů† Ů?Ů…Ů† Ů…Ů†Ů‡Ř§ Ů…Ů†Ů‡ Ů?ŮŠ Ů?Ů?ŮŠ Ů?ŮŠŮ‡Ř§ Ů?ŮŠŮ‡ Ů? Ů? Ř«Ů… Ř§Ů? ŘŁŮ? Ř¨ Ř¨Ů‡Ř§ Ř¨Ů‡ Ř§ ŘŁ Ř§Ů‰ Ř§ŮŠ ŘŁŮŠ ŘŁŮ‰ Ů„Ř§ Ů?Ů„Ř§ Ř§Ů„Ř§ ŘŁŮ„Ř§ ŘĄŮ„Ř§ Ů„Ů?Ů† Ů…Ř§ Ů?Ů…Ř§ Ů?Ů…Ř§ Ů?Ů…Ř§ ŘąŮ† Ů…Řą Ř§Ř°Ř§ ŘĄŘ°Ř§ Ř§Ů† ŘŁŮ† ŘĄŮ† Ř§Ů†Ů‡Ř§ ŘŁŮ†Ů‡Ř§ ŘĄŮ†Ů‡Ř§ Ř§Ů†Ů‡ ŘŁŮ†Ů‡ ŘĄŮ†Ů‡ Ř¨Ř§Ů† Ř¨ŘŁŮ† Ů?Ř§Ů† Ů?ŘŁŮ† Ů?Ř§Ů† Ů?ŘŁŮ† Ů?ŘĄŮ† Ř§Ů„ŘŞŮ‰ Ř§Ů„ŘŞŮŠ Ř§Ů„Ř°Ů‰ Ř§Ů„Ř°ŮŠ Ř§Ů„Ř°ŮŠŮ† Ř§Ů„Ů‰ Ř§Ů„ŮŠ ŘĄŮ„Ů‰ ŘĄŮ„ŮŠ ŘąŮ„Ů‰ ŘąŮ„ŮŠŮ‡Ř§ ŘąŮ„ŮŠŮ‡ Ř§Ů…Ř§ ŘŁŮ…Ř§ ŘĄŮ…Ř§ Ř§ŮŠŘ¶Ř§ ŘŁŮŠŘ¶Ř§ Ů?Ů„ Ů?Ů?Ů„ Ů„Ů… Ů?Ů„Ů… Ů„Ů† Ů?Ů„Ů† Ů‡Ů‰ Ů‡ŮŠ Ů‡Ů? Ů?Ů‡Ů‰ Ů?Ů‡ŮŠ Ů?Ů‡Ů? Ů?Ů‡Ů‰ Ů?Ů‡ŮŠ Ů?Ů‡Ů? Ř§Ů†ŘŞ ŘŁŮ†ŘŞ Ů„Ů? Ů„Ů‡Ř§ Ů„Ů‡ Ů‡Ř°Ů‡ Ů‡Ř°Ř§ ŘŞŮ„Ů? Ř°Ů„Ů? Ů‡Ů†Ř§Ů? Ů?Ř§Ů†ŘŞ Ů?Ř§Ů† ŮŠŮ?Ů?Ů† ŘŞŮ?Ů?Ů† Ů?Ů?Ř§Ů†ŘŞ Ů?Ů?Ř§Ů† ŘşŮŠŘ± Ř¨ŘąŘ¶ Ů‚ŘŻ Ů†Ř­Ů? Ř¨ŮŠŮ† Ř¨ŮŠŮ†Ů…Ř§ Ů…Ů†Ř° Ř¶Ů…Ů† Ř­ŮŠŘ« Ř§Ů„Ř§Ů† Ř§Ů„Ř˘Ů† Ř®Ů„Ř§Ů„ Ř¨ŘąŘŻ Ů‚Ř¨Ů„ Ř­ŘŞŮ‰ ŘąŮ†ŘŻ ŘąŮ†ŘŻŮ…Ř§ Ů„ŘŻŮ‰ Ř¬Ů…ŮŠŘą

### Armenian \(hy\)<a name="armenian"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_hy_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  ŐˇŐµŐ¤ ŐˇŐµŐ¬ ŐˇŐµŐ¶ ŐˇŐµŐ˝ Ő¤Ő¸Ö‚ Ő¤Ő¸Ö‚Ö„ ŐĄŐ´ ŐĄŐ¶ ŐĄŐ¶Ö„ ŐĄŐ˝ ŐĄÖ„ Ő§ Ő§Ő« Ő§Ő«Ő¶ Ő§Ő«Ő¶Ö„ Ő§Ő«Ö€ Ő§Ő«Ö„ Ő§Ö€ Ő¨Ő˝Őż Ő© Ő« Ő«Ő¶ Ő«Ő˝ŐŻ Ő«Ö€ ŐŻŐˇŐ´ Ő°ŐˇŐ´ŐˇÖ€ Ő°ŐĄŐż Ő°ŐĄŐżŐ¸ Ő´ŐĄŐ¶Ö„ Ő´ŐĄŐ» Ő´Ő« Ő¶ Ő¶Őˇ Ő¶ŐˇÖ‡ Ő¶Ö€Őˇ Ő¶Ö€ŐˇŐ¶Ö„ Ő¸Ö€ Ő¸Ö€Ő¨ Ő¸Ö€Ő¸Ő¶Ö„ Ő¸Ö€ŐşŐĄŐ˝ Ő¸Ö‚ Ő¸Ö‚Ő´ ŐşŐ«ŐżŐ« ŐľÖ€Őˇ Ö‡

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

  Đ° Đ°Đ· Đ°ĐşĐľ Đ°Đ»Đ° Đ±Đµ Đ±ĐµĐ· Đ±ĐµŃ?Đµ Đ±Đ¸ Đ±Đ¸Đ» Đ±Đ¸Đ»Đ° Đ±Đ¸Đ»Đ¸ Đ±Đ¸Đ»Đľ Đ±Đ»Đ¸Đ·Đľ Đ±ŃŠĐ´Đ°Ń‚ Đ±ŃŠĐ´Đµ Đ±ŃŹŃ…Đ° Đ˛ Đ˛Đ°Ń? Đ˛Đ°Ń? Đ˛Đ°Ń?Đ° Đ˛ĐµŃ€ĐľŃŹŃ‚Đ˝Đľ Đ˛ĐµŃ‡Đµ Đ˛Đ·ĐµĐĽĐ° Đ˛Đ¸ Đ˛Đ¸Đµ Đ˛Đ¸Đ˝Đ°ĐłĐ¸ Đ˛Ń?Đµ Đ˛Ń?ĐµĐşĐ¸ Đ˛Ń?Đ¸Ń‡ĐşĐ¸ Đ˛Ń?Đ¸Ń‡ĐşĐľ Đ˛Ń?ŃŹĐşĐ° Đ˛ŃŠĐ˛ Đ˛ŃŠĐżŃ€ĐµĐşĐ¸ Đ˛ŃŠŃ€Ń…Ń? Đł ĐłĐ¸ ĐłĐ»Đ°Đ˛Đ˝Đľ ĐłĐľ Đ´ Đ´Đ° Đ´Đ°Đ»Đ¸ Đ´Đľ Đ´ĐľĐşĐ°Ń‚Đľ Đ´ĐľĐşĐľĐłĐ° Đ´ĐľŃ€Đ¸ Đ´ĐľŃ?ĐµĐłĐ° Đ´ĐľŃ?Ń‚Đ° Đµ ĐµĐ´Đ˛Đ° ĐµĐ´Đ¸Đ˝ ĐµŃ‚Đľ Đ·Đ° Đ·Đ°Đ´ Đ·Đ°ĐµĐ´Đ˝Đľ Đ·Đ°Ń€Đ°Đ´Đ¸ Đ·Đ°Ń?ĐµĐłĐ° Đ·Đ°Ń‚ĐľĐ˛Đ° Đ·Đ°Ń‰Đľ Đ·Đ°Ń‰ĐľŃ‚Đľ Đ¸ Đ¸Đ· Đ¸Đ»Đ¸ Đ¸ĐĽ Đ¸ĐĽĐ° Đ¸ĐĽĐ°Ń‚ Đ¸Ń?ĐşĐ° Đą ĐşĐ°Đ·Đ° ĐşĐ°Đş ĐşĐ°ĐşĐ˛Đ° ĐşĐ°ĐşĐ˛Đľ ĐşĐ°ĐşŃ‚Đľ ĐşĐ°ĐşŃŠĐ˛ ĐşĐ°Ń‚Đľ ĐşĐľĐłĐ° ĐşĐľĐłĐ°Ń‚Đľ ĐşĐľĐµŃ‚Đľ ĐşĐľĐ¸Ń‚Đľ ĐşĐľĐą ĐşĐľĐąŃ‚Đľ ĐşĐľĐ»ĐşĐľ ĐşĐľŃŹŃ‚Đľ ĐşŃŠĐ´Đµ ĐşŃŠĐ´ĐµŃ‚Đľ ĐşŃŠĐĽ Đ»Đ¸ ĐĽ ĐĽĐµ ĐĽĐµĐ¶Đ´Ń? ĐĽĐµĐ˝ ĐĽĐ¸ ĐĽĐ˝ĐľĐ·Đ¸Đ˝Đ° ĐĽĐľĐłĐ° ĐĽĐľĐłĐ°Ń‚ ĐĽĐľĐ¶Đµ ĐĽĐľĐ»ŃŹ ĐĽĐľĐĽĐµĐ˝Ń‚Đ° ĐĽŃ? Đ˝ Đ˝Đ° Đ˝Đ°Đ´ Đ˝Đ°Đ·Đ°Đ´ Đ˝Đ°Đą Đ˝Đ°ĐżŃ€Đ°Đ˛Đ¸ Đ˝Đ°ĐżŃ€ĐµĐ´ Đ˝Đ°ĐżŃ€Đ¸ĐĽĐµŃ€ Đ˝Đ°Ń? Đ˝Đµ Đ˝ĐµĐłĐľ Đ˝ĐµŃŹ Đ˝Đ¸ Đ˝Đ¸Đµ Đ˝Đ¸ĐşĐľĐą Đ˝Đ¸Ń‚Đľ Đ˝Đľ Đ˝ŃŹĐşĐľĐ¸ Đ˝ŃŹĐşĐľĐą Đ˝ŃŹĐĽĐ° ĐľĐ±Đ°Ń‡Đµ ĐľĐşĐľĐ»Đľ ĐľŃ?Đ˛ĐµĐ˝ ĐľŃ?ĐľĐ±ĐµĐ˝Đľ ĐľŃ‚ ĐľŃ‚ĐłĐľŃ€Đµ ĐľŃ‚Đ˝ĐľĐ˛Đľ ĐľŃ‰Đµ ĐżĐ°Đş ĐżĐľ ĐżĐľĐ˛ĐµŃ‡Đµ ĐżĐľĐ˛ĐµŃ‡ĐµŃ‚Đľ ĐżĐľĐ´ ĐżĐľĐ˝Đµ ĐżĐľŃ€Đ°Đ´Đ¸ ĐżĐľŃ?Đ»Đµ ĐżĐľŃ‡Ń‚Đ¸ ĐżŃ€Đ°Đ˛Đ¸ ĐżŃ€ĐµĐ´ ĐżŃ€ĐµĐ´Đ¸ ĐżŃ€ĐµĐ· ĐżŃ€Đ¸ ĐżŃŠĐş ĐżŃŠŃ€Đ˛Đľ Ń? Ń?Đ° Ń?Đ°ĐĽĐľ Ń?Đµ Ń?ĐµĐłĐ° Ń?Đ¸ Ń?ĐşĐľŃ€Đľ Ń?Đ»ĐµĐ´ Ń?ĐĽĐµ Ń?ĐżĐľŃ€ĐµĐ´ Ń?Ń€ĐµĐ´ Ń?Ń€ĐµŃ‰Ń? Ń?Ń‚Đµ Ń?ŃŠĐĽ Ń?ŃŠŃ? Ń?ŃŠŃ‰Đľ Ń‚ Ń‚Đ°Đ·Đ¸ Ń‚Đ°ĐşĐ° Ń‚Đ°ĐşĐ¸Đ˛Đ° Ń‚Đ°ĐşŃŠĐ˛ Ń‚Đ°ĐĽ Ń‚Đ˛ĐľĐą Ń‚Đµ Ń‚ĐµĐ·Đ¸ Ń‚Đ¸ Ń‚Đ˝ Ń‚Đľ Ń‚ĐľĐ˛Đ° Ń‚ĐľĐłĐ°Đ˛Đ° Ń‚ĐľĐ·Đ¸ Ń‚ĐľĐą Ń‚ĐľĐ»ĐşĐľĐ˛Đ° Ń‚ĐľŃ‡Đ˝Đľ Ń‚Ń€ŃŹĐ±Đ˛Đ° Ń‚Ń?Đş Ń‚ŃŠĐą Ń‚ŃŹ Ń‚ŃŹŃ… Ń? Ń…Đ°Ń€ĐµŃ?Đ˛Đ° Ń‡ Ń‡Đµ Ń‡ĐµŃ?Ń‚Đľ Ń‡Ń€ĐµĐ· Ń‰Đµ Ń‰ĐľĐĽ ŃŹ

### Catalan \(ca\)<a name="catalan"></a>

Algorithmic stemming options: `full`

Elision filter enabled

Default analysis scheme: `_ca_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  a abans acĂ­ ah aixĂ­ aixĂ˛ al als aleshores algun alguna algunes alguns alhora allĂ  allĂ­ allĂ˛ altra altre altres amb ambdĂłs ambdues apa aquell aquella aquelles aquells aquest aquesta aquestes aquests aquĂ­ baix cada cadascĂş cadascuna cadascunes cadascuns com contra d'un d'una d'unes d'uns dalt de del dels des desprĂ©s dins dintre donat doncs durant e eh el els em en encara ens entre Ă©rem eren Ă©reu es Ă©s esta estĂ  estĂ vem estaven estĂ veu esteu et etc ets fins fora gairebĂ© ha han has havia he hem heu hi ho i igual iguals ja l'hi la les li li'n llavors m'he ma mal malgrat mateix mateixa mateixes mateixos me mentre mĂ©s meu meus meva meves molt molta moltes molts mon mons n'he n'hi ne ni no nogensmenys nomĂ©s nosaltres nostra nostre nostres o oh oi on pas pel pels per perĂ˛ perquĂ¨ poc poca pocs poques potser propi qual quals quan quant que quĂ¨ quelcom qui quin quina quines quins s'ha s'han sa semblant semblants ses seu seus seva seva seves si sobre sobretot sĂłc solament sols son sĂłn sons sota sou t'ha t'han t'he ta tal tambĂ© tampoc tan tant tanta tantes teu teus teva teves ton tons tot tota totes tots un una unes uns us va vaig vam van vas veu vosaltres vostra vostre vostres

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

  a s k o i u v z dnes cz tĂ­mto budeĹˇ budem byli jseĹˇ mĹŻj svĂ˝m ta tomto tohle tuto tyto jej zda proÄŤ mĂˇte tato kam tohoto kdo kteĹ™Ă­ mi nĂˇm tom tomuto mĂ­t nic proto kterou byla toho protoĹľe asi ho naĹˇi napiĹˇte re coĹľ tĂ­m takĹľe svĂ˝ch jejĂ­ svĂ˝mi jste aj tu tedy teto bylo kde ke pravĂ© ji nad nejsou ÄŤi pod tĂ©ma mezi pĹ™es ty pak vĂˇm ani kdyĹľ vĹˇak neg jsem tento ÄŤlĂˇnku ÄŤlĂˇnky aby jsme pĹ™ed pta jejich byl jeĹˇtÄ› aĹľ bez takĂ© pouze prvnĂ­ vaĹˇe kterĂˇ nĂˇs novĂ˝ tipy pokud mĹŻĹľe strana jeho svĂ© jinĂ© zprĂˇvy novĂ© nenĂ­ vĂˇs jen podle zde uĹľ bĂ˝t vĂ­ce bude jiĹľ neĹľ kterĂ˝ by kterĂ© co nebo ten tak mĂˇ pĹ™i od po jsou jak dalĹˇĂ­ ale si se ve to jako za zpÄ›t ze do pro je na atd atp jakmile pĹ™iÄŤemĹľ jĂˇ on ona ono oni ony my vy jĂ­ ji mÄ› mne jemu tomu tÄ›m tÄ›mu nÄ›mu nÄ›muĹľ jehoĹľ jĂ­Ĺľ jelikoĹľ jeĹľ jakoĹľ naÄŤeĹľ

### Danish \(da\)<a name="danish"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_da_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  og i jeg det at en den til er som pĂĄ de med han af for ikke der var mig sig men et har om vi min havde ham hun nu over da fra du ud sin dem os op man hans hvor eller hvad skal selv her alle vil blev kunne ind nĂĄr vĂ¦re dog noget ville jo deres efter ned skulle denne end dette mit ogsĂĄ under have dig anden hende mine alt meget sit sine vor mod disse hvis din nogle hos blive mange ad bliver hendes vĂ¦ret thi jer sĂĄdan

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

  olla olen olet on olemme olette ovat ole oli olisi olisit olisin olisimme olisitte olisivat olit olin olimme olitte olivat ollut olleet en et ei emme ette eivĂ¤t minĂ¤ minun minut minua minussa minusta minuun minulla minulta minulle sinĂ¤ sinun sinut sinua sinussa sinusta sinuun sinulla sinulta sinulle hĂ¤n hĂ¤nen hĂ¤net hĂ¤ntĂ¤ hĂ¤nessĂ¤ hĂ¤nestĂ¤ hĂ¤neen hĂ¤nellĂ¤ hĂ¤neltĂ¤ hĂ¤nelle me meidĂ¤n meidĂ¤t meitĂ¤ meissĂ¤ meistĂ¤ meihin meillĂ¤ meiltĂ¤ meille te teidĂ¤n teidĂ¤t teitĂ¤ teissĂ¤ teistĂ¤ teihin teillĂ¤ teiltĂ¤ teille he heidĂ¤n heidĂ¤t heitĂ¤ heissĂ¤ heistĂ¤ heihin heillĂ¤ heiltĂ¤ heille tĂ¤mĂ¤ tĂ¤mĂ¤n tĂ¤tĂ¤ tĂ¤ssĂ¤ tĂ¤stĂ¤ tĂ¤hĂ¤n tallĂ¤ tĂ¤ltĂ¤ tĂ¤lle tĂ¤nĂ¤ tĂ¤ksi tuo tuon tuotĂ¤ tuossa tuosta tuohon tuolla tuolta tuolle tuona tuoksi se sen sitĂ¤ siinĂ¤ siitĂ¤ siihen sillĂ¤ siltĂ¤ sille sinĂ¤ siksi nĂ¤mĂ¤ nĂ¤iden nĂ¤itĂ¤ nĂ¤issĂ¤ nĂ¤istĂ¤ nĂ¤ihin nĂ¤illĂ¤ nĂ¤iltĂ¤ nĂ¤ille nĂ¤inĂ¤ nĂ¤iksi nuo noiden noita noissa noista noihin noilla noilta noille noina noiksi ne niiden niitĂ¤ niissĂ¤ niistĂ¤ niihin niillĂ¤ niiltĂ¤ niille niinĂ¤ niiksi kuka kenen kenet ketĂ¤ kenessĂ¤ kenestĂ¤ keneen kenellĂ¤ keneltĂ¤ kenelle kenenĂ¤ keneksi ketkĂ¤ keiden ketkĂ¤ keitĂ¤ keissĂ¤ keistĂ¤ keihin keillĂ¤ keiltĂ¤ keille keinĂ¤ keiksi mikĂ¤ minkĂ¤ minkĂ¤ mitĂ¤ missĂ¤ mistĂ¤ mihin millĂ¤ miltĂ¤ mille minĂ¤ miksi mitkĂ¤ joka jonka jota jossa josta johon jolla jolta jolle jona joksi jotka joiden joita joissa joista joihin joilla joilta joille joina joiksi ettĂ¤ ja jos koska kuin mutta niin sekĂ¤ sillĂ¤ tai vaan vai vaikka kanssa mukaan noin poikki yli kun niin nyt itse

### French \(fr\)<a name="french"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Elision filter enabled

Default analysis scheme: `_fr_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  au aux avec ce ces dans de des du elle en et eux il je la le leur lui ma mais me mĂŞme mes moi mon ne nos notre nous on ou par pas pour qu que qui sa se ses son sur ta te tes toi ton tu un une vos votre vous c d j l Ă  m n s t y Ă©tĂ© Ă©tĂ©e Ă©tĂ©es Ă©tĂ©s Ă©tant suis es est sommes ĂŞtes sont serai seras sera serons serez seront serais serait serions seriez seraient Ă©tais Ă©tait Ă©tions Ă©tiez Ă©taient fus fut fĂ»mes fĂ»tes furent sois soit soyons soyez soient fusse fusses fĂ»t fussions fussiez fussent ayant eu eue eues eus ai as avons avez ont aurai auras aura aurons aurez auront aurais aurait aurions auriez auraient avais avait avions aviez avaient eut eĂ»mes eĂ»tes eurent aie aies ait ayons ayez aient eusse eusses eĂ»t eussions eussiez eussent ceci celĂ Â  cet cette ici ils les leurs quel quels quelle quelles sans soi

### Galician \(gl\)<a name="galician"></a>

Algorithmic stemming options: `minimal`\|`full`

Default analysis scheme: `_gl_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  \# galican stopwords a aĂ­nda alĂ­ aquel aquela aquelas aqueles aquilo aquĂ­ ao aos as asĂ­ Ăˇ ben cando che co coa comigo con connosco contigo convosco coas cos cun cuns cunha cunhas da dalgunha dalgunhas dalgĂşn dalgĂşns das de del dela delas deles desde deste do dos dun duns dunha dunhas e el ela elas eles en era eran esa esas ese eses esta estar estaba estĂˇ estĂˇn este estes estiven estou eu Ă© facer foi foron fun habĂ­a hai iso isto la las lle lles lo los mais me meu meus min miĂ±a miĂ±as moi na nas neste nin no non nos nosa nosas noso nosos nĂłs nun nunha nuns nunhas o os ou Ăł Ăłs para pero pode pois pola polas polo polos por que se senĂłn ser seu seus sexa sido sobre sĂşa sĂşas tamĂ©n tan te ten teĂ±en teĂ±o ter teu teus ti tido tiĂ±a tiven tĂşa tĂşas un unha unhas uns vos vosa vosas voso vosos vĂłs 

### German \(de\)<a name="german"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_de_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  aber alle allem allen aller alles als also am an ander andere anderem anderen anderer anderes anderm andern anderr anders auch auf aus bei bin bis bist da damit dann der den des dem die das daĂź derselbe derselben denselben desselben demselben dieselbe dieselben dasselbe dazu dein deine deinem deinen deiner deines denn derer dessen dich dir du dies diese diesem diesen dieser dieses doch dort durch ein eine einem einen einer eines einig einige einigem einigen einiger einiges einmal er ihn ihm es etwas euer eure eurem euren eurer eures fĂĽr gegen gewesen hab habe haben hat hatte hatten hier hin hinter ich mich mir ihr ihre ihrem ihren ihrer ihres euch im in indem ins ist jede jedem jeden jeder jedes jene jenem jenen jener jenes jetzt kann kein keine keinem keinen keiner keines kĂ¶nnen kĂ¶nnte machen man manche manchem manchen mancher manches mein meine meinem meinen meiner meines mit muss musste nach nicht nichts noch nun nur ob oder ohne sehr sein seine seinem seinen seiner seines selbst sich sie ihnen sind so solche solchem solchen solcher solches soll sollte sondern sonst ĂĽber um und uns unse unsem unsen unser unses unter viel vom von vor wĂ¤hrend war waren warst was weg weil weiter welche welchem welchen welcher welches wenn werde werden wie wieder will wir wird wirst wo wollen wollte wĂĽrde wĂĽrden zu zum zur zwar zwischen

### Greek \(el\)<a name="greek"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_el_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  Îż Î· Ď„Îż ÎżÎą Ď„Î± Ď„ÎżĎ… Ď„Î·Ď? Ď„Ď‰Î˝ Ď„ÎżÎ˝ Ď„Î·Î˝ ÎşÎ±Îą ÎşÎą Îş ÎµÎąÎĽÎ±Îą ÎµÎąĎ?Î±Îą ÎµÎąÎ˝Î±Îą ÎµÎąÎĽÎ±Ď?Ď„Îµ ÎµÎąĎ?Ď„Îµ Ď?Ď„Îż Ď?Ď„ÎżÎ˝ Ď?Ď„Î· Ď?Ď„Î·Î˝ ÎĽÎ± Î±Î»Î»Î± Î±Ď€Îż ÎłÎąÎ± Ď€Ď?ÎżĎ? ÎĽÎµ Ď?Îµ Ď‰Ď? Ď€Î±Ď?Î± Î±Î˝Ď„Îą ÎşÎ±Ď„Î± ÎĽÎµĎ„Î± Î¸Î± Î˝Î± Î´Îµ Î´ÎµÎ˝ ÎĽÎ· ÎĽÎ·Î˝ ÎµĎ€Îą ÎµÎ˝Ď‰ ÎµÎ±Î˝ Î±Î˝ Ď„ÎżĎ„Îµ Ď€ÎżĎ… Ď€Ď‰Ď? Ď€ÎżÎąÎżĎ? Ď€ÎżÎąÎ± Ď€ÎżÎąÎż Ď€ÎżÎąÎżÎą Ď€ÎżÎąÎµĎ? Ď€ÎżÎąĎ‰Î˝ Ď€ÎżÎąÎżĎ…Ď? Î±Ď…Ď„ÎżĎ? Î±Ď…Ď„Î· Î±Ď…Ď„Îż Î±Ď…Ď„ÎżÎą Î±Ď…Ď„Ď‰Î˝ Î±Ď…Ď„ÎżĎ…Ď? Î±Ď…Ď„ÎµĎ? Î±Ď…Ď„Î± ÎµÎşÎµÎąÎ˝ÎżĎ? ÎµÎşÎµÎąÎ˝Î· ÎµÎşÎµÎąÎ˝Îż ÎµÎşÎµÎąÎ˝ÎżÎą ÎµÎşÎµÎąÎ˝ÎµĎ? ÎµÎşÎµÎąÎ˝Î± ÎµÎşÎµÎąÎ˝Ď‰Î˝ ÎµÎşÎµÎąÎ˝ÎżĎ…Ď? ÎżĎ€Ď‰Ď? ÎżÎĽĎ‰Ď? ÎąĎ?Ď‰Ď? ÎżĎ?Îż ÎżĎ„Îą

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

  a ahogy ahol aki akik akkor alatt Ăˇltal ĂˇltalĂˇban amely amelyek amelyekben amelyeket amelyet amelynek ami amit amolyan amĂ­g amikor Ăˇt abban ahhoz annak arra arrĂłl az azok azon azt azzal azĂ©rt aztĂˇn azutĂˇn azonban bĂˇr be belĂĽl benne cikk cikkek cikkeket csak de e eddig egĂ©sz egy egyes egyetlen egyĂ©b egyik egyre ekkor el elĂ©g ellen elĹ‘ elĹ‘szĂ¶r elĹ‘tt elsĹ‘ Ă©n Ă©ppen ebben ehhez emilyen ennek erre ez ezt ezek ezen ezzel ezĂ©rt Ă©s fel felĂ© hanem hiszen hogy hogyan igen Ă­gy illetve ill\. ill ilyen ilyenkor ison ismĂ©t itt jĂł jĂłl jobban kell kellett keresztĂĽl keressĂĽnk ki kĂ­vĂĽl kĂ¶zĂ¶tt kĂ¶zĂĽl legalĂˇbb lehet lehetett legyen lenne lenni lesz lett maga magĂˇt majd majd mĂˇr mĂˇs mĂˇsik meg mĂ©g mellett mert mely melyek mi mit mĂ­g miĂ©rt milyen mikor minden mindent mindenki mindig mint mintha mivel most nagy nagyobb nagyon ne nĂ©ha nekem neki nem nĂ©hĂˇny nĂ©lkĂĽl nincs olyan ott Ă¶ssze Ĺ‘ Ĺ‘k Ĺ‘ket pedig persze rĂˇ s sajĂˇt sem semmi sok sokat sokkal szĂˇmĂˇra szemben szerint szinte talĂˇn tehĂˇt teljes tovĂˇbb tovĂˇbbĂˇ tĂ¶bb Ăşgy ugyanis Ăşj Ăşjabb Ăşjra utĂˇn utĂˇna utolsĂł vagy vagyis valaki valami valamint valĂł vagyok van vannak volt voltam voltak voltunk vissza vele viszont volna

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

  a ach ag agus an aon ar arna as b' ba beirt bhĂşr caoga ceathair ceathrar chomh chtĂł chuig chun cois cĂ©ad cĂşig cĂşigear d' daichead dar de deich deichniĂşr den dhĂˇ do don dtĂ­ dĂˇ dĂˇr dĂł faoi faoin faoina faoinĂˇr fara fiche gach gan go gur haon hocht i iad idir in ina ins inĂˇr is le leis lena lenĂˇr m' mar mo mĂ© na nach naoi naonĂşr nĂˇ nĂ­ nĂ­or nĂł nĂłcha ocht ochtar os roimh sa seacht seachtar seachtĂł seasca seisear siad sibh sinn sna sĂ© sĂ­ tar thar thĂş triĂşr trĂ­ trĂ­na trĂ­nĂˇr trĂ­ocha tĂş um Ăˇr Ă© Ă©is Ă­ Ăł Ăłn Ăłna ĂłnĂˇr

### Italian \(it\)<a name="italian"></a>

Algorithmic stemming options: `light`\|`full`

Elision filter enabled

Default analysis scheme: `_it_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  ad al allo ai agli all agl alla alle con col coi da dal dallo dai dagli dall dagl dalla dalle di del dello dei degli dell degl della delle in nel nello nei negli nell negl nella nelle su sul sullo sui sugli sull sugl sulla sulle per tra contro io tu lui lei noi voi loro mio mia miei mie tuo tua tuoi tue suo sua suoi sue nostro nostra nostri nostre vostro vostra vostri vostre mi ti ci vi lo la li le gli ne il un uno una ma ed se perchĂ© anche come dov dove che chi cui non piĂą quale quanto quanti quanta quante quello quelli quella quelle questo questi questa queste si tutto tutti a c e i l o ho hai ha abbiamo avete hanno abbia abbiate abbiano avrĂ˛ avrai avrĂ  avremo avrete avranno avrei avresti avrebbe avremmo avreste avrebbero avevo avevi aveva avevamo avevate avevano ebbi avesti ebbe avemmo aveste ebbero avessi avesse avessimo avessero avendo avuto avuta avuti avute sono sei Ă¨ siamo siete sia siate siano sarĂ˛ sarai sarĂ  saremo sarete saranno sarei saresti sarebbe saremmo sareste sarebbero ero eri era eravamo eravate erano fui fosti fu fummo foste furono fossi fosse fossimo fossero essendo faccio fai facciamo fanno faccia facciate facciano farĂ˛ farai farĂ  faremo farete faranno farei faresti farebbe faremmo fareste farebbero facevo facevi faceva facevamo facevate facevano feci facesti fece facemmo faceste fecero facessi facesse facessimo facessero facendo sto stai sta stiamo stanno stia stiate stiano starĂ˛ starai starĂ  staremo starete staranno starei staresti starebbe staremmo stareste starebbero stavo stavi stava stavamo stavate stavano stetti stesti stette stemmo steste stettero stessi stesse stessimo stessero stando

### Japanese \(ja\)<a name="japanese"></a>

Algorithmic stemming options: `full`

Algorithmic decompounding enabled

Optional tokenization dictionary

Default analysis scheme: `_ja_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  ă?® ă?« ă?Ż ă‚’ ă?ź ă?Ś ă?§ ă?¦ ă?¨ ă?— ă‚Ś ă?• ă?‚ă‚‹ ă?„ă‚‹ ă‚‚ ă?™ă‚‹ ă?‹ă‚‰ ă?Ş ă?“ă?¨ ă?¨ă?—ă?¦ ă?„ ă‚„ ă‚Śă‚‹ ă?Şă?© ă?Şă?Ł ă?Şă?„ ă?“ă?® ă?źă‚? ă?ťă?® ă?‚ă?Ł ă‚?ă?† ă?ľă?ź ă‚‚ă?® ă?¨ă?„ă?† ă?‚ă‚Š ă?ľă?§ ă‚‰ă‚Ś ă?Şă‚‹ ă?¸ ă?‹ ă?  ă?“ă‚Ś ă?«ă‚?ă?Łă?¦ ă?«ă‚?ă‚Š ă?Šă‚Š ă‚?ă‚Š ă?«ă‚?ă‚‹ ă?š ă?Şă‚Š ă‚‰ă‚Śă‚‹ ă?«ă?Šă?„ă?¦ ă?° ă?Şă?‹ă?Ł ă?Şă?Ź ă?—ă?‹ă?— ă?«ă?¤ă?„ă?¦ ă?› ă? ă?Ł ă?ťă?®ĺľŚ ă?§ă?Ťă‚‹ ă?ťă‚Ś ă?† ă?®ă?§ ă?Şă?Š ă?®ă?ż ă?§ă?Ť ă?Ť ă?¤ ă?«ă?Šă?‘ă‚‹ ă?Šă‚?ă?ł ă?„ă?† ă?•ă‚‰ă?« ă?§ă‚‚ ă‚‰ ă?źă‚Š ă?ťă?®ä»– ă?«é–˘ă?™ă‚‹ ă?źă?ˇ ă?ľă?™ ă‚“ ă?Şă‚‰ ă?«ĺŻľă?—ă?¦ ç‰ąă?« ă?›ă‚‹ ĺŹŠă?ł ă?“ă‚Śă‚‰ ă?¨ă?Ť ă?§ă?Ż ă?«ă?¦ ă?»ă?‹ ă?Şă?Śă‚‰ ă?†ă?ˇ ă?ťă?—ă?¦ ă?¨ă?¨ă‚‚ă?« ă?źă? ă?— ă?‹ă?¤ă?¦ ă?ťă‚Śă?žă‚Ś ă?ľă?źă?Ż ă?Š ă?»ă?© ă‚‚ă?®ă?® ă?«ĺŻľă?™ă‚‹ ă?»ă?¨ă‚“ă?© ă?¨ĺ…±ă?« ă?¨ă?„ă?Łă?ź ă?§ă?™ ă?¨ă‚‚ ă?¨ă?“ă‚Ť ă?“ă?“

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

  aiz ap ar apakĹˇ Ä?rpus augĹˇpus bez caur dÄ“ÄĽ gar iekĹˇ iz kopĹˇ labad lejpus lÄ«dz no otrpus pa par pÄ?r pÄ“c pie pirms pret priekĹˇ starp Ĺˇaipus uz viĹ†pus virs virspus zem apakĹˇpus un bet jo ja ka lai tomÄ“r tikko turpretÄ« arÄ« kaut gan tÄ?dÄ“ÄĽ tÄ? ne tikvien vien kÄ? ir te vai kamÄ“r ar diezin droĹˇi diemĹľÄ“l nebĹ«t ik it taÄŤu nu pat tiklab iekĹˇpus nedz tik nevis turpretim jeb iekam iekÄ?m iekÄ?ms kolÄ«dz lÄ«dzko tiklÄ«dz jebĹˇu tÄ?lab tÄ?pÄ“c nekÄ? itin jÄ? jau jel nÄ“ nezin tad tikai vis tak iekams vien bĹ«t biju biji bija bijÄ?m bijÄ?t esmu esi esam esat bĹ«Ĺˇu bĹ«si bĹ«s bĹ«sim bĹ«siet tikt tiku tiki tika tikÄ?m tikÄ?t tieku tiec tiek tiekam tiekat tikĹˇu tiks tiksim tiksiet tapt tapi tapÄ?t topat tapĹˇu tapsi taps tapsim tapsiet kÄĽĹ«t kÄĽuvu kÄĽuvi kÄĽuva kÄĽuvÄ?m kÄĽuvÄ?t kÄĽĹ«stu kÄĽĹ«sti kÄĽĹ«st kÄĽĹ«stam kÄĽĹ«stat kÄĽĹ«Ĺˇu kÄĽĹ«si kÄĽĹ«s kÄĽĹ«sim kÄĽĹ«siet varÄ“t varÄ“ju varÄ“jÄ?m varÄ“Ĺˇu varÄ“sim var varÄ“ji varÄ“jÄ?t varÄ“si varÄ“siet varat varÄ“ja varÄ“s

### Multiple \(mul\)<a name="multiple"></a>

Algorithmic stemming: not supported

Default analysis scheme: `_mul_default_`
+ Default stopword dictionary

### Norwegian \(no\)<a name="norwegian"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_no_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  og i jeg det at en et den til er som pĂĄ de med han av ikke ikkje der sĂĄ var meg seg men ett har om vi min mitt ha hadde hun nĂĄ over da ved fra du ut sin dem oss opp man kan hans hvor eller hva skal selv sjĂ¸l her alle vil bli ble blei blitt kunne inn nĂĄr vĂ¦re kom noen noe ville dere som deres kun ja etter ned skulle denne for deg si sine sitt mot ĂĄ meget hvorfor dette disse uten hvordan ingen din ditt blir samme hvilken hvilke sĂĄnn inni mellom vĂĄr hver hvem vors hvis bĂĄde bare enn fordi fĂ¸r mange ogsĂĄ slik vĂ¦rt vĂ¦re bĂĄe begge siden dykk dykkar dei deira deires deim di dĂĄ eg ein eit eitt elles honom hjĂĄ ho hoe henne hennar hennes hoss hossen ikkje ingi inkje korleis korso kva kvar kvarhelst kven kvi kvifor me medan mi mine mykje no nokon noka nokor noko nokre si sia sidan so somt somme um upp vere vore verte vort varte vart

### Persian \(fa\)<a name="persian"></a>

Algorithmic stemming not supported

Default analysis scheme: `_fa_default_`
+ Default stopword dictionary:

  Ř§Ů†Ř§Ů† Ů†ŘŻŘ§Ř´ŘŞŮ‡ ŘłŘ±Ř§ŘłŘ± Ř®ŮŠŘ§Ů‡ Ř§ŮŠŘ´Ř§Ů† Ů?ŮŠ ŘŞŘ§Ů?Ů†Ů?Ů† Ř¨ŮŠŘ´ŘŞŘ±ŮŠ ŘŻŮ?Ů… ŮľŘł Ů†Ř§Ř´ŮŠ Ů?ÚŻŮ? ŮŠŘ§ ŘŻŘ§Ř´ŘŞŮ†ŘŻ ŘłŮľŘł Ů‡Ů†ÚŻŘ§Ů… Ů‡Ř±ÚŻŘ˛ ŮľŮ†Ř¬ Ů†Ř´Ř§Ů† Ř§Ů…ŘłŘ§Ů„ ŘŻŮŠÚŻŘ± ÚŻŘ±Ů?Ů‡ŮŠ Ř´ŘŻŮ†ŘŻ Ú†Ř·Ů?Ř± ŘŻŮ‡ Ů? ŘŻŮ? Ů†Ř®ŘłŘŞŮŠŮ† Ů?Ů„ŮŠ Ú†Ř±Ř§ Ú†Ů‡ Ů?ŘłŘ· Ů‡ Ů?ŘŻŘ§Ů… Ů‚Ř§Ř¨Ů„ ŮŠŮ? Ř±Ů?ŘŞ Ů‡Ů?ŘŞ Ů‡Ů…Ú†Ů†ŮŠŮ† ŘŻŘ± Ů‡Ř˛Ř§Ř± Ř¨Ů„Ů‡ Ř¨Ů„ŮŠ Ř´Ř§ŮŠŘŻ Ř§Ů…Ř§ Ř´Ů†Ř§ŘłŮŠ ÚŻŘ±Ů?ŘŞŮ‡ ŘŻŮ‡ŘŻ ŘŻŘ§Ř´ŘŞŮ‡ ŘŻŘ§Ů†ŘłŘŞ ŘŻŘ§Ř´ŘŞŮ† Ř®Ů?Ř§Ů‡ŮŠŮ… Ů…ŮŠŮ„ŮŠŘ§Ř±ŘŻ Ů?Ů‚ŘŞŮŠŮ?Ů‡ Ř§Ů…ŘŻ Ř®Ů?Ř§Ů‡ŘŻ Ř¬Ř˛ Ř§Ů?Ř±ŘŻŮ‡ Ř´ŘŻŮ‡ Ř¨Ů„Ů?Ů‡ Ř®ŘŻŮ…Ř§ŘŞ Ř´ŘŻŮ† Ř¨Ř±Ř®ŮŠ Ů†Ř¨Ů?ŘŻ Ř¨ŘłŮŠŘ§Ř±ŮŠ Ř¬Ů„Ů?ÚŻŮŠŘ±ŮŠ Ř­Ů‚ Ů?Ř±ŘŻŮ†ŘŻ Ů†Ů?ŘąŮŠ Ř¨ŘąŘ±ŮŠ Ů†Ů?Ř±ŘŻŮ‡ Ů†Ř¸ŮŠŘ± Ů†Ř¨Ř§ŮŠŘŻ Ř¨Ů?ŘŻŮ‡ Ř¨Ů?ŘŻŮ† ŘŻŘ§ŘŻ Ř§Ů?Ř±ŘŻ Ů‡ŘłŘŞ Ř¬Ř§ŮŠŮŠ Ř´Ů?ŘŻ ŘŻŮ†Ř¨Ř§Ů„ ŘŻŘ§ŘŻŮ‡ Ř¨Ř§ŮŠŘŻ ŘłŘ§Ř¨Ů‚ Ů‡ŮŠÚ† Ů‡Ů…Ř§Ů† Ř§Ů†Ř¬Ř§ Ů?Ů…ŘŞŘ± Ů?Ř¬Ř§ŘłŘŞ ÚŻŘ±ŘŻŘŻ Ů?ŘłŮŠ ŘŞŘ± Ů…Ř±ŘŻŮ… ŘŞŘ§Ů† ŘŻŘ§ŘŻŮ† Ř¨Ů?ŘŻŮ†ŘŻ ŘłŘ±ŮŠ Ř¬ŘŻŘ§ Ů†ŘŻŘ§Ř±Ů†ŘŻ Ů…ÚŻŘ± ŮŠŮ?ŘŻŮŠÚŻŘ± ŘŻŘ§Ř±ŘŻ ŘŻŮ‡Ů†ŘŻ Ř¨Ů†Ř§Ř¨Ř±Ř§ŮŠŮ† Ů‡Ů†ÚŻŘ§Ů…ŮŠ ŘłŮ…ŘŞ Ř¬Ř§ Ř§Ů†Ú†Ů‡ Ř®Ů?ŘŻ ŘŻŘ§ŘŻŮ†ŘŻ Ř˛ŮŠŘ§ŘŻ ŘŻŘ§Ř±Ů†ŘŻ Ř§Ř«Ř± Ř¨ŘŻŮ?Ů† Ř¨Ů‡ŘŞŘ±ŮŠŮ† Ř¨ŮŠŘ´ŘŞŘ± Ř§Ů„Ř¨ŘŞŮ‡ Ř¨Ů‡ Ř¨Ř±Ř§ŘłŘ§Řł Ř¨ŮŠŘ±Ů?Ů† Ů?Ř±ŘŻ Ř¨ŘąŘ¶ŮŠ ÚŻŘ±Ů?ŘŞ ŘŞŮ?ŮŠ Ř§ŮŠ Ů…ŮŠŮ„ŮŠŮ?Ů† Ř§Ů? Ř¬Ř±ŮŠŘ§Ů† ŘŞŮ?Ů„ Ř¨Ř± Ů…Ř§Ů†Ů†ŘŻ Ř¨Ř±Ř§Ř¨Ř± Ř¨Ř§Ř´ŮŠŮ… Ů…ŘŻŘŞŮŠ ÚŻŮ?ŮŠŮ†ŘŻ Ř§Ů?Ů†Ů?Ů† ŘŞŘ§ ŘŞŮ†Ů‡Ř§ Ř¬ŘŻŮŠŘŻ Ú†Ů†ŘŻ Ř¨ŮŠ Ů†Ř´ŘŻŮ‡ Ů?Ř±ŘŻŮ† Ů?Ř±ŘŻŮ… ÚŻŮ?ŮŠŘŻ Ů?Ř±ŘŻŮ‡ Ů?Ů†ŮŠŮ… Ů†Ů…ŮŠ Ů†Ř˛ŘŻ Ř±Ů?ŮŠ Ů‚ŘµŘŻ Ů?Ů‚Ř· Ř¨Ř§Ů„Ř§ŮŠ ŘŻŮŠÚŻŘ±Ř§Ů† Ř§ŮŠŮ† ŘŻŮŠŘ±Ů?Ř˛ ŘŞŮ?ŘłŘ· ŘłŮ?Ů… Ř§ŮŠŮ… ŘŻŘ§Ů†Ů†ŘŻ ŘłŮ?ŮŠ Ř§ŘłŘŞŮ?Ř§ŘŻŮ‡ Ř´Ů…Ř§ Ů?Ů†Ř§Ř± ŘŻŘ§Ř±ŮŠŮ… ŘłŘ§Ř®ŘŞŮ‡ Ř·Ů?Ř± Ř§Ů…ŘŻŮ‡ Ř±Ů?ŘŞŮ‡ Ů†Ř®ŘłŘŞ Ř¨ŮŠŘłŘŞ Ů†Ř˛ŘŻŮŠŮ? Ř·ŮŠ Ů?Ů†ŮŠŘŻ Ř§Ř˛ Ř§Ů†Ů‡Ř§ ŘŞŮ…Ř§Ů…ŮŠ ŘŻŘ§Ř´ŘŞ ŮŠŮ?ŮŠ Ř·Ř±ŮŠŮ‚ Ř§Ř´ Ú†ŮŠŘłŘŞ Ř±Ů?Ř¨ Ů†Ů…Ř§ŮŠŘŻ ÚŻŮ?ŘŞ Ú†Ů†ŘŻŮŠŮ† Ú†ŮŠŘ˛ŮŠ ŘŞŮ?Ř§Ů†ŘŻ Ř§Ů… Ř§ŮŠŘ§ Ř¨Ř§ Ř§Ů† Ř§ŮŠŘŻ ŘŞŘ±ŮŠŮ† Ř§ŮŠŮ†Ů?Ů‡ ŘŻŮŠÚŻŘ±ŮŠ Ř±Ř§Ů‡ Ů‡Ř§ŮŠŮŠ Ř¨Ř±Ů?Ř˛ Ů‡Ů…Ú†Ů†Ř§Ů† ŮľŘ§ŘąŮŠŮ† Ů?Řł Ř­ŘŻŮ?ŘŻ Ů…Ř®ŘŞŮ„Ů? Ů…Ů‚Ř§Ř¨Ů„ Ú†ŮŠŘ˛ ÚŻŮŠŘ±ŘŻ Ů†ŘŻŘ§Ř±ŘŻ Ř¶ŘŻ Ů‡Ů…Ú†Ů?Ů† ŘłŘ§Ř˛ŮŠ Ř´Ř§Ů† Ů…Ů?Ř±ŘŻ Ř¨Ř§Ř±Ů‡ Ů…Ř±ŘłŮŠ Ř®Ů?ŮŠŘ´ Ř¨Ř±Ř®Ů?Ř±ŘŻŘ§Ř± Ú†Ů?Ů† Ř®Ř§Ř±Ř¬ Ř´Ř´ Ů‡Ů†Ů?Ř˛ ŘŞŘ­ŘŞ Ř¶Ů…Ů† Ů‡ŘłŘŞŮŠŮ… ÚŻŮ?ŘŞŮ‡ Ů?Ů?Ř± Ř¨ŘłŮŠŘ§Ř± ŮľŮŠŘ´ Ř¨Ř±Ř§ŮŠ Ř±Ů?Ř˛Ů‡Ř§ŮŠ Ř§Ů†Ů?Ů‡ Ů†Ř®Ů?Ř§Ů‡ŘŻ Ř¨Ř§Ů„Ř§ Ů?Ů„ Ů?Ů‚ŘŞŮŠ Ů?ŮŠ Ú†Ů†ŮŠŮ† Ů?Ů‡ ÚŻŮŠŘ±ŮŠ Ů†ŮŠŘłŘŞ Ř§ŘłŘŞ Ů?Ř¬Ř§ Ů?Ů†ŘŻ Ů†ŮŠŘ˛ ŮŠŘ§Ř¨ŘŻ Ř¨Ů†ŘŻŮŠ Ř­ŘŞŮŠ ŘŞŮ?Ř§Ů†Ů†ŘŻ ŘąŮ‚Ř¨ Ř®Ů?Ř§ŘłŘŞ Ů?Ů†Ů†ŘŻ Ř¨ŮŠŮ† ŘŞŮ…Ř§Ů… Ů‡Ů…Ů‡ Ů…Ř§ Ř¨Ř§Ř´Ů†ŘŻ Ů…Ř«Ů„ Ř´ŘŻ Ř§Ř±ŮŠ Ř¨Ř§Ř´ŘŻ Ř§Ř±Ů‡ Ř·Ř¨Ů‚ Ř¨ŘąŘŻ Ř§ÚŻŘ± ŘµŮ?Ř±ŘŞ ŘşŮŠŘ± Ř¬Ř§ŮŠ Ř¨ŮŠŘ´ Ř±ŮŠŘ˛ŮŠ Ř§Ů†ŘŻ Ř˛ŮŠŘ±Ř§ Ú†ÚŻŮ?Ů†Ů‡ Ř¨Ř§Ř± Ů„Ř·Ů?Ř§ Ů…ŮŠ ŘŻŘ±Ř¨Ř§Ř±Ů‡ Ů…Ů† ŘŻŮŠŘŻŮ‡ Ů‡Ů…ŮŠŮ† ÚŻŘ°Ř§Ř±ŮŠ Ř¨Ř±ŘŻŘ§Ř±ŮŠ ŘąŮ„ŘŞ ÚŻŘ°Ř§Ř´ŘŞŮ‡ Ů‡Ů… Ů?Ů?Ů‚ Ů†Ů‡ Ů‡Ř§ Ř´Ů?Ů†ŘŻ Ř§Ř¨Ř§ŘŻ Ů‡Ů…Ů?Ř§Ř±Ů‡ Ů‡Ř± Ř§Ů?Ů„ Ř®Ů?Ř§Ů‡Ů†ŘŻ Ú†Ů‡Ř§Ř± Ů†Ř§Ů… Ř§Ů…Ř±Ů?Ř˛ Ů…Ř§Ů† Ů‡Ř§ŮŠ Ů‚Ř¨Ů„ Ů?Ů†Ů… ŘłŘąŮŠ ŘŞŘ§Ř˛Ů‡ Ř±Ř§ Ů‡ŘłŘŞŮ†ŘŻ Ř˛ŮŠŘ± Ř¬Ů„Ů?ŮŠ ŘąŮ†Ů?Ř§Ů† Ř¨Ů?ŘŻ

### Portuguese \(pt\)<a name="portuguese"></a>

Algorithmic stemming options: `minimal`\|`light`\|`full`

Default analysis scheme: `_pt_default_`
+ Algorithmic stemming: `minimal`
+ Default stopword dictionary:

  de a o que e do da em um para com nĂŁo uma os no se na por mais as dos como mas ao ele das Ă  seu sua ou quando muito nos jĂˇ eu tambĂ©m sĂł pelo pela atĂ© isso ela entre depois sem mesmo aos seus quem nas me esse eles vocĂŞ essa num nem suas meu Ă s minha numa pelos elas qual nĂłs lhe deles essas esses pelas este dele tu te vocĂŞs vos lhes meus minhas teu tua teus tuas nosso nossa nossos nossas dela delas esta estes estas aquele aquela aqueles aquelas isto aquilo estou estĂˇ estamos estĂŁo estive esteve estivemos estiveram estava estĂˇvamos estavam estivera estivĂ©ramos esteja estejamos estejam estivesse estivĂ©ssemos estivessem estiver estivermos estiverem hei hĂˇ havemos hĂŁo houve houvemos houveram houvera houvĂ©ramos haja hajamos hajam houvesse houvĂ©ssemos houvessem houver houvermos houverem houverei houverĂˇ houveremos houverĂŁo houveria houverĂ­amos houveriam sou somos sĂŁo era Ă©ramos eram fui foi fomos foram fora fĂ´ramos seja sejamos sejam fosse fĂ´ssemos fossem for formos forem serei serĂˇ seremos serĂŁo seria serĂ­amos seriam tenho tem temos tĂ©m tinha tĂ­nhamos tinham tive teve tivemos tiveram tivera tivĂ©ramos tenha tenhamos tenham tivesse tivĂ©ssemos tivessem tiver tivermos tiverem terei terĂˇ teremos terĂŁo teria terĂ­amos teriam

### Romanian \(ro\)<a name="romanian"></a>

Algorithmic stemming options: `full`

Default analysis scheme: `_ro_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary:

  acea aceasta aceastÄ? aceea acei aceia acel acela acele acelea acest acesta aceste acestea aceĹźti aceĹźtia acolo acum ai aia aibÄ? aici al Ä?la ale alea Ä?lea altceva altcineva am ar are aĹź aĹźadar asemenea asta Ä?sta astÄ?zi astea Ä?stea Ä?Ĺźtia asupra aĹŁi au avea avem aveĹŁi azi bine bucur bunÄ? ca cÄ? cÄ?ci cĂ˘nd care cÄ?rei cÄ?ror cÄ?rui cĂ˘t cĂ˘te cĂ˘ĹŁi cÄ?tre cĂ˘tva ce cel ceva chiar cĂ®nd cine cineva cĂ®t cĂ®te cĂ®ĹŁi cĂ®tva contra cu cum cumva curĂ˘nd curĂ®nd da dÄ? dacÄ? dar datoritÄ? de deci deja deoarece departe deĹźi din dinaintea dintr dintre drept dupÄ? ea ei el ele eram este eĹźti eu face fÄ?rÄ? fi fie fiecare fii fim fiĹŁi iar ieri Ă®i Ă®l Ă®mi Ă®mpotriva Ă®n Ă®nainte Ă®naintea Ă®ncĂ˘t Ă®ncĂ®t Ă®ncotro Ă®ntre Ă®ntrucĂ˘t Ă®ntrucĂ®t Ă®ĹŁi la lĂ˘ngÄ? le li lĂ®ngÄ? lor lui mÄ? mĂ˘ine mea mei mele mereu meu mi mine mult multÄ? mulĹŁi ne nicÄ?ieri nici nimeni niĹźte noastrÄ? noastre noi noĹźtri nostru nu ori oricĂ˘nd oricare oricĂ˘t orice oricĂ®nd oricine oricĂ®t oricum oriunde pĂ˘nÄ? pe pentru peste pĂ®nÄ? poate pot prea prima primul prin printr sa sÄ? sÄ?i sale sau sÄ?u se Ĺźi sĂ®nt sĂ®ntem sĂ®nteĹŁi spre sub sunt suntem sunteĹŁi ta tÄ?i tale tÄ?u te ĹŁi ĹŁie tine toatÄ? toate tot toĹŁi totuĹźi tu un una unde undeva unei unele uneori unor vÄ? vi voastrÄ? voastre voi voĹźtri vostru vouÄ? vreo vreun

### Russian \(ru\)<a name="russian"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_ru_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  Đ¸ Đ˛ Đ˛Đľ Đ˝Đµ Ń‡Ń‚Đľ ĐľĐ˝ Đ˝Đ° ŃŹ Ń? Ń?Đľ ĐşĐ°Đş Đ° Ń‚Đľ Đ˛Ń?Đµ ĐľĐ˝Đ° Ń‚Đ°Đş ĐµĐłĐľ Đ˝Đľ Đ´Đ° Ń‚Ń‹ Đş Ń? Đ¶Đµ Đ˛Ń‹ Đ·Đ° Đ±Ń‹ ĐżĐľ Ń‚ĐľĐ»ŃŚĐşĐľ ĐµĐµ ĐĽĐ˝Đµ Đ±Ń‹Đ»Đľ Đ˛ĐľŃ‚ ĐľŃ‚ ĐĽĐµĐ˝ŃŹ ĐµŃ‰Đµ Đ˝ĐµŃ‚ Đľ Đ¸Đ· ĐµĐĽŃ? Ń‚ĐµĐżĐµŃ€ŃŚ ĐşĐľĐłĐ´Đ° Đ´Đ°Đ¶Đµ Đ˝Ń? Đ˛Đ´Ń€Ń?Đł Đ»Đ¸ ĐµŃ?Đ»Đ¸ Ń?Đ¶Đµ Đ¸Đ»Đ¸ Đ˝Đ¸ Đ±Ń‹Ń‚ŃŚ Đ±Ń‹Đ» Đ˝ĐµĐłĐľ Đ´Đľ Đ˛Đ°Ń? Đ˝Đ¸Đ±Ń?Đ´ŃŚ ĐľĐżŃŹŃ‚ŃŚ Ń?Đ¶ Đ˛Đ°ĐĽ Ń?ĐşĐ°Đ·Đ°Đ» Đ˛ĐµĐ´ŃŚ Ń‚Đ°ĐĽ ĐżĐľŃ‚ĐľĐĽ Ń?ĐµĐ±ŃŹ Đ˝Đ¸Ń‡ĐµĐłĐľ ĐµĐą ĐĽĐľĐ¶ĐµŃ‚ ĐľĐ˝Đ¸ Ń‚Ń?Ń‚ ĐłĐ´Đµ ĐµŃ?Ń‚ŃŚ Đ˝Đ°Đ´Đľ Đ˝ĐµĐą Đ´Đ»ŃŹ ĐĽŃ‹ Ń‚ĐµĐ±ŃŹ Đ¸Ń… Ń‡ĐµĐĽ Đ±Ń‹Đ»Đ° Ń?Đ°ĐĽ Ń‡Ń‚ĐľĐ± Đ±ĐµĐ· Đ±Ń?Đ´Ń‚Đľ Ń‡ĐµĐ»ĐľĐ˛ĐµĐş Ń‡ĐµĐłĐľ Ń€Đ°Đ· Ń‚ĐľĐ¶Đµ Ń?ĐµĐ±Đµ ĐżĐľĐ´ Đ¶Đ¸Đ·Đ˝ŃŚ Đ±Ń?Đ´ĐµŃ‚ Đ¶ Ń‚ĐľĐłĐ´Đ° ĐşŃ‚Đľ ŃŤŃ‚ĐľŃ‚ ĐłĐľĐ˛ĐľŃ€Đ¸Đ» Ń‚ĐľĐłĐľ ĐżĐľŃ‚ĐľĐĽŃ? ŃŤŃ‚ĐľĐłĐľ ĐşĐ°ĐşĐľĐą Ń?ĐľĐ˛Ń?ĐµĐĽ Đ˝Đ¸ĐĽ Đ·Đ´ĐµŃ?ŃŚ ŃŤŃ‚ĐľĐĽ ĐľĐ´Đ¸Đ˝ ĐżĐľŃ‡Ń‚Đ¸ ĐĽĐľĐą Ń‚ĐµĐĽ Ń‡Ń‚ĐľĐ±Ń‹ Đ˝ĐµĐµ ĐşĐ°Đ¶ĐµŃ‚Ń?ŃŹ Ń?ĐµĐąŃ‡Đ°Ń? Đ±Ń‹Đ»Đ¸ ĐşŃ?Đ´Đ° Đ·Đ°Ń‡ĐµĐĽ Ń?ĐşĐ°Đ·Đ°Ń‚ŃŚ Đ˛Ń?ĐµŃ… Đ˝Đ¸ĐşĐľĐłĐ´Đ° Ń?ĐµĐłĐľĐ´Đ˝ŃŹ ĐĽĐľĐ¶Đ˝Đľ ĐżŃ€Đ¸ Đ˝Đ°ĐşĐľĐ˝ĐµŃ† Đ´Đ˛Đ° ĐľĐ± Đ´Ń€Ń?ĐłĐľĐą Ń…ĐľŃ‚ŃŚ ĐżĐľŃ?Đ»Đµ Đ˝Đ°Đ´ Đ±ĐľĐ»ŃŚŃ?Đµ Ń‚ĐľŃ‚ Ń‡ĐµŃ€ĐµĐ· ŃŤŃ‚Đ¸ Đ˝Đ°Ń? ĐżŃ€Đľ Đ˛Ń?ĐµĐłĐľ Đ˝Đ¸Ń… ĐşĐ°ĐşĐ°ŃŹ ĐĽĐ˝ĐľĐłĐľ Ń€Đ°Đ·Đ˛Đµ Ń?ĐşĐ°Đ·Đ°Đ»Đ° Ń‚Ń€Đ¸ ŃŤŃ‚Ń? ĐĽĐľŃŹ Đ˛ĐżŃ€ĐľŃ‡ĐµĐĽ Ń…ĐľŃ€ĐľŃ?Đľ Ń?Đ˛ĐľŃŽ ŃŤŃ‚ĐľĐą ĐżĐµŃ€ĐµĐ´ Đ¸Đ˝ĐľĐłĐ´Đ° Đ»Ń?Ń‡Ń?Đµ Ń‡Ń?Ń‚ŃŚ Ń‚ĐľĐĽ Đ˝ĐµĐ»ŃŚĐ·ŃŹ Ń‚Đ°ĐşĐľĐą Đ¸ĐĽ Đ±ĐľĐ»ĐµĐµ Đ˛Ń?ĐµĐłĐ´Đ° ĐşĐľĐ˝ĐµŃ‡Đ˝Đľ Đ˛Ń?ŃŽ ĐĽĐµĐ¶Đ´Ń?

### Spanish \(es\)<a name="spanish"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_es_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  de la que el en y a los del se las por un para con no una su al lo como mĂˇs pero sus le ya o este sĂ­ porque esta entre cuando muy sin sobre tambiĂ©n me hasta hay donde quien desde todo nos durante todos uno les ni contra otros ese eso ante ellos e esto mĂ­ antes algunos quĂ© unos yo otro otras otra Ă©l tanto esa estos mucho quienes nada muchos cual poco ella estar estas algunas algo nosotros mi mis tĂş te ti tu tus ellas nosotras vosotros vosotras os mĂ­o mĂ­a mĂ­os mĂ­as tuyo tuya tuyos tuyas suyo suya suyos suyas nuestro nuestra nuestros nuestras vuestro vuestra vuestros vuestras esos esas estoy estĂˇs estĂˇ estamos estĂˇis estĂˇn estĂ© estĂ©s estemos estĂ©is estĂ©n estarĂ© estarĂˇs estarĂˇ estaremos estarĂ©is estarĂˇn estarĂ­a estarĂ­as estarĂ­amos estarĂ­ais estarĂ­an estaba estabas estĂˇbamos estabais estaban estuve estuviste estuvo estuvimos estuvisteis estuvieron estuviera estuvieras estuviĂ©ramos estuvierais estuvieran estuviese estuvieses estuviĂ©semos estuvieseis estuviesen estando estado estada estados estadas estad he has ha hemos habĂ©is han haya hayas hayamos hayĂˇis hayan habrĂ© habrĂˇs habrĂˇ habremos habrĂ©is habrĂˇn habrĂ­a habrĂ­as habrĂ­amos habrĂ­ais habrĂ­an habĂ­a habĂ­as habĂ­amos habĂ­ais habĂ­an hube hubiste hubo hubimos hubisteis hubieron hubiera hubieras hubiĂ©ramos hubierais hubieran hubiese hubieses hubiĂ©semos hubieseis hubiesen habiendo habido habida habidos habidas soy eres es somos sois son sea seas seamos seĂˇis sean serĂ© serĂˇs serĂˇ seremos serĂ©is serĂˇn serĂ­a serĂ­as serĂ­amos serĂ­ais serĂ­an era eras Ă©ramos erais eran fui fuiste fue fuimos fuisteis fueron fuera fueras fuĂ©ramos fuerais fueran fuese fueses fuĂ©semos fueseis fuesen siendo sido tengo tienes tiene tenemos tenĂ©is tienen tenga tengas tengamos tengĂˇis tengan tendrĂ© tendrĂˇs tendrĂˇ tendremos tendrĂ©is tendrĂˇn tendrĂ­a tendrĂ­as tendrĂ­amos tendrĂ­ais tendrĂ­an tenĂ­a tenĂ­as tenĂ­amos tenĂ­ais tenĂ­an tuve tuviste tuvo tuvimos tuvisteis tuvieron tuviera tuvieras tuviĂ©ramos tuvierais tuvieran tuviese tuvieses tuviĂ©semos tuvieseis tuviesen teniendo tenido tenida tenidos tenidas tened

### Swedish \(sv\)<a name="swedish"></a>

Algorithmic stemming options: `light`\|`full`

Default analysis scheme: `_sv_default_`
+ Algorithmic stemming: `light`
+ Default stopword dictionary:

  och det att i en jag hon som han pĂĄ den med var sig fĂ¶r sĂĄ till Ă¤r men ett om hade de av icke mig du henne dĂĄ sin nu har inte hans honom skulle hennes dĂ¤r min man ej vid kunde nĂĄgot frĂĄn ut nĂ¤r efter upp vi dem vara vad Ă¶ver Ă¤n dig kan sina hĂ¤r ha mot alla under nĂĄgon eller allt mycket sedan ju denna sjĂ¤lv detta ĂĄt utan varit hur ingen mitt ni bli blev oss din dessa nĂĄgra deras blir mina samma vilken er sĂĄdan vĂĄr blivit dess inom mellan sĂĄdant varfĂ¶r varje vilka ditt vem vilket sitta sĂĄdana vart dina vars vĂĄrt vĂĄra ert era vilkas

### Thai \(th\)<a name="thai"></a>

Algorithmic stemming not supported

Stemming dictionary not supported

Default analysis scheme: `_th_default_`
+ Default stopword dictionary:

  ŕą„ŕ¸§ŕą‰ ŕą„ŕ¸ˇŕą? ŕą„ŕ¸› ŕą„ŕ¸”ŕą‰ ŕą?ŕ¸«ŕą‰ ŕą?ŕ¸™ ŕą‚ŕ¸”ŕ¸˘ ŕą?ŕ¸«ŕą?ŕ¸‡ ŕą?ŕ¸Ąŕą‰ŕ¸§ ŕą?ŕ¸Ąŕ¸° ŕą?ŕ¸Łŕ¸? ŕą?ŕ¸šŕ¸š ŕą?ŕ¸•ŕą? ŕą€ŕ¸­ŕ¸‡ ŕą€ŕ¸«ŕą‡ŕ¸™ ŕą€ŕ¸Ąŕ¸˘ ŕą€ŕ¸Łŕ¸´ŕą?ŕ¸ˇ ŕą€ŕ¸Łŕ¸˛ ŕą€ŕ¸ˇŕ¸·ŕą?ŕ¸­ ŕą€ŕ¸žŕ¸·ŕą?ŕ¸­ ŕą€ŕ¸žŕ¸Łŕ¸˛ŕ¸° ŕą€ŕ¸›ŕą‡ŕ¸™ŕ¸?ŕ¸˛ŕ¸Ł ŕą€ŕ¸›ŕą‡ŕ¸™ ŕą€ŕ¸›ŕ¸´ŕ¸”ŕą€ŕ¸śŕ¸˘ ŕą€ŕ¸›ŕ¸´ŕ¸” ŕą€ŕ¸™ŕ¸·ŕą?ŕ¸­ŕ¸‡ŕ¸?ŕ¸˛ŕ¸? ŕą€ŕ¸”ŕ¸µŕ¸˘ŕ¸§ŕ¸?ŕ¸±ŕ¸™ ŕą€ŕ¸”ŕ¸µŕ¸˘ŕ¸§ ŕą€ŕ¸Šŕą?ŕ¸™ ŕą€ŕ¸‰ŕ¸žŕ¸˛ŕ¸° ŕą€ŕ¸„ŕ¸˘ ŕą€ŕ¸‚ŕą‰ŕ¸˛ ŕą€ŕ¸‚ŕ¸˛ ŕ¸­ŕ¸µŕ¸? ŕ¸­ŕ¸˛ŕ¸? ŕ¸­ŕ¸°ŕą„ŕ¸Ł ŕ¸­ŕ¸­ŕ¸? ŕ¸­ŕ¸˘ŕą?ŕ¸˛ŕ¸‡ ŕ¸­ŕ¸˘ŕ¸ąŕą? ŕ¸­ŕ¸˘ŕ¸˛ŕ¸? ŕ¸«ŕ¸˛ŕ¸? ŕ¸«ŕ¸Ąŕ¸˛ŕ¸˘ ŕ¸«ŕ¸Ąŕ¸±ŕ¸‡ŕ¸?ŕ¸˛ŕ¸? ŕ¸«ŕ¸Ąŕ¸±ŕ¸‡ ŕ¸«ŕ¸Łŕ¸·ŕ¸­ ŕ¸«ŕ¸™ŕ¸¶ŕą?ŕ¸‡ ŕ¸Şŕą?ŕ¸§ŕ¸™ ŕ¸Şŕą?ŕ¸‡ ŕ¸Şŕ¸¸ŕ¸” ŕ¸ŞŕąŤŕ¸˛ŕ¸«ŕ¸Łŕ¸±ŕ¸š ŕ¸§ŕą?ŕ¸˛ ŕ¸§ŕ¸±ŕ¸™ ŕ¸Ąŕ¸‡ ŕ¸Łŕą?ŕ¸§ŕ¸ˇ ŕ¸Łŕ¸˛ŕ¸˘ ŕ¸Łŕ¸±ŕ¸š ŕ¸Łŕ¸°ŕ¸«ŕ¸§ŕą?ŕ¸˛ŕ¸‡ ŕ¸Łŕ¸§ŕ¸ˇ ŕ¸˘ŕ¸±ŕ¸‡ ŕ¸ˇŕ¸µ ŕ¸ˇŕ¸˛ŕ¸? ŕ¸ˇŕ¸˛ ŕ¸žŕ¸Łŕą‰ŕ¸­ŕ¸ˇ ŕ¸žŕ¸š ŕ¸śŕą?ŕ¸˛ŕ¸™ ŕ¸śŕ¸Ą ŕ¸šŕ¸˛ŕ¸‡ ŕ¸™ŕą?ŕ¸˛ ŕ¸™ŕ¸µŕą‰ ŕ¸™ŕąŤŕ¸˛ ŕ¸™ŕ¸±ŕą‰ŕ¸™ ŕ¸™ŕ¸±ŕ¸? ŕ¸™ŕ¸­ŕ¸?ŕ¸?ŕ¸˛ŕ¸? ŕ¸—ŕ¸¸ŕ¸? ŕ¸—ŕ¸µŕą?ŕ¸Şŕ¸¸ŕ¸” ŕ¸—ŕ¸µŕą? ŕ¸—ŕąŤŕ¸˛ŕą?ŕ¸«ŕą‰ ŕ¸—ŕąŤŕ¸˛ ŕ¸—ŕ¸˛ŕ¸‡ ŕ¸—ŕ¸±ŕą‰ŕ¸‡ŕ¸™ŕ¸µŕą‰ ŕ¸—ŕ¸±ŕą‰ŕ¸‡ ŕ¸–ŕą‰ŕ¸˛ ŕ¸–ŕ¸ąŕ¸? ŕ¸–ŕ¸¶ŕ¸‡ ŕ¸•ŕą‰ŕ¸­ŕ¸‡ ŕ¸•ŕą?ŕ¸˛ŕ¸‡ŕą† ŕ¸•ŕą?ŕ¸˛ŕ¸‡ ŕ¸•ŕą?ŕ¸­ ŕ¸•ŕ¸˛ŕ¸ˇ ŕ¸•ŕ¸±ŕą‰ŕ¸‡ŕą?ŕ¸•ŕą? ŕ¸•ŕ¸±ŕą‰ŕ¸‡ ŕ¸”ŕą‰ŕ¸˛ŕ¸™ ŕ¸”ŕą‰ŕ¸§ŕ¸˘ ŕ¸”ŕ¸±ŕ¸‡ ŕ¸‹ŕ¸¶ŕą?ŕ¸‡ ŕ¸Šŕą?ŕ¸§ŕ¸‡ ŕ¸?ŕ¸¶ŕ¸‡ ŕ¸?ŕ¸˛ŕ¸? ŕ¸?ŕ¸±ŕ¸” ŕ¸?ŕ¸° ŕ¸„ŕ¸·ŕ¸­ ŕ¸„ŕ¸§ŕ¸˛ŕ¸ˇ ŕ¸„ŕ¸Łŕ¸±ŕą‰ŕ¸‡ ŕ¸„ŕ¸‡ ŕ¸‚ŕ¸¶ŕą‰ŕ¸™ ŕ¸‚ŕ¸­ŕ¸‡ ŕ¸‚ŕ¸­ ŕ¸‚ŕ¸“ŕ¸° ŕ¸?ŕą?ŕ¸­ŕ¸™ ŕ¸?ŕą‡ ŕ¸?ŕ¸˛ŕ¸Ł ŕ¸?ŕ¸±ŕ¸š ŕ¸?ŕ¸±ŕ¸™ ŕ¸?ŕ¸§ŕą?ŕ¸˛ ŕ¸?ŕ¸Ąŕą?ŕ¸˛ŕ¸§

### Turkish \(tr\)<a name="turkish"></a>

Algorithmic stemming: `full`

Default analysis scheme: `_tr_default_`
+ Algorithmic stemming: `full`
+ Default stopword dictionary