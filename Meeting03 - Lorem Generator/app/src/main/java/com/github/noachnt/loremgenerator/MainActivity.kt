package com.github.noachnt.loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ArrayAdapter.createFromResource
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.noachnt.loremgenerator.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val zombieipsum: Mydata = Mydata("Zombie Ipsum", "Zombie ipsum reversus ab viral inferno, nam rick grimes malum cerebro. De carne lumbering animata corpora quaeritis. Summus brains sit, morbo vel maleficia? De apocalypsi gorger omero undead survivor dictum mauris. Hi mindless mortuis soulless creaturas, imo evil stalking monstra adventus resi dentevil vultus comedat cerebella viventium. Qui animated corpse, cricket bat max brucks terribilem incessu zomby. The voodoo sacerdos flesh eater, suscitat mortuos comedere carnem virus. Zonbi tattered for solum oculi eorum defunctis go lum cerebro. Nescio brains an Undead zombies. Sicut malus putrid voodoo horror. Nigh tofth eliv ingdead.\n" +
                "\n" +
                "Cum horribilem walking dead resurgere de crazed sepulcris creaturis, zombie sicut de grave feeding iride et serpens. Pestilentia, shaun ofthe dead scythe animated corpses ipsa screams. Pestilentia est plague haec decaying ambulabat mortuos. Sicut zeder apathetic malus voodoo. Aenean a dolor plan et terror soulless vulnerum contagium accedunt, mortui iam vivam unlife. Qui tardius moveri, brid eof reanimator sed in magna copia sint terribiles undeath legionis. Alii missing oculis aliorum sicut serpere crabs nostram. Putridi braindead odores kill and infect, aere implent left four dead.\n" +
                "\n" +
                "Lucio fulci tremor est dark vivos magna. Expansis creepy arm yof darkness ulnis witchcraft missing carnem armis Kirkman Moore and Adlard caeruleum in locis. Romero morbo Congress amarus in auras. Nihil horum sagittis tincidunt, zombie slack-jawed gelida survival portenta. The unleashed virus est, et iam zombie mortui ambulabunt super terram. Souless mortuum glassy-eyed oculos attonitos indifferent back zom bieapoc alypse. An hoc dead snow braaaiiiins sociopathic incipere Clairvius Narcisse, an ante? Is bello mundi z?\n" +
                "\n"
    )

    private val baconipsum: Mydata = Mydata("Bacon Ipsum", "Pastrami frankfurter short loin pig meatball t-bone, shankle hamburger cupim alcatra ball tip picanha ham hock. Kevin beef brisket, biltong pig leberkas pancetta sausage sirloin andouille beef ribs shoulder pork shank. Cow ham pancetta biltong shank beef ribs corned beef tongue. Spare ribs pork chop filet mignon, pig landjaeger shankle t-bone chicken. Landjaeger boudin hamburger pork chop, pork ball tip chicken turkey alcatra swine meatloaf corned beef.\n" +
                "\n" +
                "Boudin hamburger beef ribeye chicken shank jerky ground round beef ribs venison kielbasa picanha burgdoggen. Frankfurter capicola kevin boudin flank ribeye beef ribs, tail beef ham corned beef ham hock pancetta short loin jowl. Meatloaf tri-tip meatball sirloin, doner beef ribs andouille turducken pig kevin turkey sausage. Swine flank alcatra doner short ribs bresaola boudin kielbasa landjaeger andouille tri-tip ham tenderloin. Filet mignon tail prosciutto shoulder. Prosciutto ham jowl bacon sirloin ribeye salami shankle.\n" +
                "\n" +
                "Frankfurter meatloaf short ribs, prosciutto tongue boudin turducken tri-tip short loin chuck buffalo kielbasa salami pancetta doner. Turkey shoulder biltong pork tenderloin ball tip shankle meatball fatback capicola. Boudin capicola strip steak ball tip beef. Alcatra drumstick kevin venison, pancetta capicola biltong flank picanha pork loin filet mignon shoulder meatball. Landjaeger leberkas jowl tongue meatloaf kevin."
    )

    private val dinoipsum: Mydata = Mydata("Dino Ipsum", "Muttaburrasaurus Kol Eucercosaurus Xenoposeidon Plateosauravus Dahalokely Edmontosaurus Asiatosaurus Hecatasaurus Zatomus Aniksosaurus Agujaceratops Andesaurus Astrodonius Hypsilophodon Dasygnathoides Protoceratops Equijubus Thecocoelurus Craterosaurus Teyuwasu Borogovia Epidendrosaurus Chondrosteosaurus Cathetosaurus Chinshakiangosaurus Sauroplites Elaltitan Gojirasaurus Theiophytalia Lusitanosaurus Pradhania Lurdusaurus Haya Nanningosaurus Zizhongosaurus Beishanlong Galvesaurus Phaedrolosaurus Dracorex Ischyrosaurus Neovenator Datousaurus Hoplitosaurus Stygimoloch Genyodectes Kosmoceratops Amphicoelias Mononychus Calamosaurus.\n" +
                "\n" +
                "Szechuanosaurus Graciliraptor Sinovenator Melanorosaurus Dashanpusaurus Pachysuchus Gresslyosaurus Planicoxa Gryphoceratops Gracilisuchus Morinosaurus Unaysaurus Ceratonykus Tehuelchesaurus Chienkosaurus Euhelopus Sinornithoides Yaxartosaurus Altispinax Jeholosaurus Xuanhanosaurus Lusitanosaurus Ajkaceratops Baotianmansaurus Lessemsaurus Hylosaurus Guaibasaurus Protoceratops Campylodoniscus Campylodon Bagaraatan Umarsaurus Kangnasaurus Halticosaurus Udanoceratops Creosaurus Pukyongosaurus Yangchuanosaurus Stegoceras Ricardoestesia Camposaurus Maleevosaurus Supersaurus Magnosaurus Serendipaceratops Kuszholia Zizhongosaurus Nurosaurus Zapalasaurus Creosaurus.\n" +
                "\n" +
                "Duriatitan Cedrorestes Velafrons Andesaurus Elopteryx Dystrophaeus Afrovenator Balaur Ahshislepelta Hulsanpes Protognathus Angulomastacator Elmisaurus Maxakalisaurus Santanaraptor Unquillosaurus Genusaurus Aristosuchus Dystrophaeus Lucianosaurus Xiaosaurus Xiaosaurus Lusitanosaurus Wulagasaurus Creosaurus Dromiceiomimus Seismosaurus Antarctosaurus Gryphoceratops Probactrosaurus Sphenosuchus Zanabazar Karongasaurus Chungkingosaurus Batyrosaurus Liliensternus Palaeoctonus Postosuchus Rapator Agnosphitys Nodosaurus Variraptor Anasazisaurus Trachodon Rileyasuchus Geranosaurus Erketu Sinocoelurus Hypacrosaurus Deinodon.\n"
    )

    private val baseballipsum: Mydata = Mydata("Baseball Ipsum", "Range grass save team cellar pull steal ground ball knuckleball. Grass bench right field wild pitch check swing no-hitter 1-2-3 silver slugger. Forkball fenway bench pennant plate, rake triple-A flyout doubleheader. Starting pitcher shutout contact on deck nubber relief pitcher right fielder interleague inning. Shift shortstop dribbler fenway butcher boy cup of coffee ejection. Shutout rally pitchout second baseman wins left on base peanuts pennant no decision.\n" +
                "\n" +
                "Crooked number range cycle team around the horn rookie silver slugger on deck starting pitcher. Screwball balk cracker jack sweep slide ground rule double wrigley left field. Retire rubber game chin music mitt appeal check swing streak fan. Skipper wrigley extra innings mitt error foul pole cork on-base percentage. All-star flyout all-star knuckle mound hall of fame bandbox. World series reliever hit by pitch forkball center field, base swing slider cup of coffee.\n" +
                "\n" +
                "Series knuckleball second base sport hack all-star club left on base forkball. Passed ball cookie rotation loogy assist off-speed hack. Southpaw pinch hit stretch leadoff good eye line drive triple play double play. Rake contact slide on deck shutout rhubarb curve. Take can of corn bandbox robbed shortstop, no decision flyout can of corn yankees. Can of corn left fielder bleeder tigers cup of coffee fielder's choice in the hole pull."
    )

    private val hackeripsum: Mydata = Mydata("Hacker Ipsum", "Haxx0r ipsum tunnel in irc gurfle linux shell Trojan horse headers semaphore ip nak win d00dz leet protected back door I'm compiling. Kilo giga eaten by a grue recursively blob root eof pwned sql fail hash rm -rf ssh sudo false man pages script kiddies gcc emacs. Ascii bang class /dev/null mainframe syn echo snarf highjack suitably small values. Leapfrog mailbomb error stack buffer cat regex void continue Linus Torvalds float try catch wabbit bubble sort. Printf deadlock epoch bypass injection foad public socket long stack trace fopen concurrently cache client dereference brute force Donald Knuth ctl-c. Salt January 1, 1970 pragma if gobble warez wombat machine code protocol. New vi salt tarball ban afk private finally terminal kilo malloc Starcraft flood gnu L0phtCrack crack. Interpreter overflow race condition data loop rsa python ifdef lib while throw bin bit packet sniffer. Foo alloc flush ascii Dennis Ritchie wannabee thread exception ack segfault boolean gc strlen cookie do worm mega break grep. Else over clock then leapfrog daemon baz system hack the mainframe interpreter James T. Kirk server todo mutex.\n" +
                "\n" +
                "Sudo infinite loop Trojan horse spoof true epoch else terminal. If gcc hexadecimal ascii mountain dew vi private stdio.h I'm sorry Dave, I'm afraid I can't do that. Cd L0phtCrack bubble sort try catch function afk mega it's a feature syn gnu cd eaten by a grue Starcraft bin Leslie Lamport case fopen hack the mainframe. Sql stack unix strlen highjack tcp less foad int mainframe fork fail while ssh wannabee giga null mailbomb. Pwned cat flood big-endian suitably small values tera shell python sudo piggyback. Alloc segfault long flush tunnel in worm todo bit ifdef bar var new bytes packet. Injection for malloc rm -rf foo memory leak recursively false snarf script kiddies Donald Knuth bang rsa client dereference I'm compiling. Dennis Ritchie baz public server void daemon race condition error all your base are belong to us. Back door tarball perl James T. Kirk endif salt default nak system port if loop hash. Cache wabbit protected class ip d00dz gurfle over clock January 1, 1970 grep buffer warez echo printf brute force then.\n" +
                "\n" +
                "Irc fail gcc protocol char class server bytes segfault if irc endif flush Leslie Lamport. Bang do alloc client break bubble sort while daemon data try catch wannabee ssh Donald Knuth infinite loop. New crack emacs socket win gc loop highjack thread syn linux else. Finally overflow baz int rm -rf python foo cd memory leak mainframe /dev/null sql tarball snarf. Man pages ifdef headers terminal sudo salt leet todo double epoch bit deadlock. Hexadecimal function perl semaphore January 1, 1970. Flood regex wabbit mountain dew root tcp dereference access ban. Stack malloc machine code it's a feature packet race condition I'm compiling buffer case then new echo all your base are belong to us. Null ip kilo hello world bin firewall d00dz stdio.h nak eaten by a grue L0phtCrack flood pragma continue protected mega eof float printf. Leapfrog var back door hexadecimal cache script kiddies error foad I'm sorry Dave, I'm afraid I can't do that.\n" +
                "\n"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            zombieipsum = zombieipsum
            baconipsum = baconipsum
            dinoipsum = dinoipsum
            baseballipsum = baseballipsum
            hackeripsum = hackeripsum
        }

        val adapter = ArrayAdapter.createFromResource(this, R.array.lorem_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremSpinner.adapter = adapter

        binding.loremSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.loremSpinner.getItemAtPosition(position).toString()
                when (currentType) {
                    "Zombie Ipsum" -> {
                        binding.titleText.text = zombieipsum.type
                        binding.loremText.text = zombieipsum.content
                    }
                    "Bacon Ipsum" -> {
                        binding.titleText.text = baconipsum.type
                        binding.loremText.text = baconipsum.content
                    }
                    "Dino Ipsum" -> {
                        binding.titleText.text = dinoipsum.type
                        binding.loremText.text = dinoipsum.content
                    }
                    "Baseball Ipsum" -> {
                        binding.titleText.text = baseballipsum.type
                        binding.loremText.text = baseballipsum.content
                    }
                    "Hacker Ipsum" -> {
                        binding.titleText.text = hackeripsum.type
                        binding.loremText.text = hackeripsum.content
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator","well, if nothing selected")
            }

        }

        binding.creatorButton.setOnClickListener {
            pickCreatorName(binding.creatorButton)
            it.hideKeyboard()
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)



        }
    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun pickCreatorName(view: View) {
        binding.apply {
            creatorText.text = creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            view.visibility = View.GONE
            loremSpinner.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }


    }


    private fun changeCreatorName(view: View) {
        binding.apply {
            view.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremSpinner.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}