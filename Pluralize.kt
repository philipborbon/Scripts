/**
 * Base on the work of
 *
 * Pluralize.swift
 * link:
 * https://github.com/joshualat/Pluralize.swift
 *
 * usage:
 * "Tooth".pluralize
 * "Nutrtion".pluralize
 * "House".pluralize(count: 1)
 * "Person".pluralize(count: 2,  "Persons")
 *
 */
class Pluralize {
    private var uncountables: ArrayList<String> = arrayListOf (
        "access", "accommodation", "adulthood", "advertising", "advice",
        "aggression", "aid", "air", "alcohol", "anger", "applause",
        "arithmetic", "art", "assistance", "athletics", "attention",
        "bacon", "baggage", "ballet", "beauty", "beef", "beer", "biology",
        "botany", "bread", "butter", "carbon", "cash", "chaos", "cheese",
        "chess", "childhood", "clothing", "coal", "coffee", "commerce",
        "compassion", "comprehension", "content", "corruption", "cotton",
        "courage", "currency", "dancing", "danger", "data", "delight",
        "dignity", "dirt", "distribution", "dust", "economics", "education",
        "electricity", "employment", "engineering", "envy", "equipment",
        "ethics", "evidence", "evolution", "faith", "fame", "fish", "flour", "flu",
        "food", "freedom", "fuel", "fun", "furniture", "garbage", "garlic",
        "genetics", "gold", "golf", "gossip", "grammar", "gratitude", "grief",
        "ground", "guilt", "gymnastics", "hair", "happiness", "hardware",
        "harm", "hate", "hatred", "health", "heat", "height", "help", "homework",
        "honesty", "honey", "hospitality", "housework", "humour", "hunger",
        "hydrogen", "ice", "ice", "cream", "importance", "inflation", "information",
        "injustice", "innocence", "iron", "irony", "jealousy", "jelly", "judo",
        "karate", "kindness", "knowledge", "labour", "lack", "laughter", "lava",
        "leather", "leisure", "lightning", "linguistics", "litter", "livestock",
        "logic", "loneliness", "luck", "luggage", "machinery", "magic",
        "management", "mankind", "marble", "mathematics", "mayonnaise",
        "measles", "meat", "methane", "milk", "money", "mud", "music", "nature",
        "news", "nitrogen", "nonsense", "nurture", "nutrition", "obedience",
        "obesity", "oil", "oxygen", "passion", "pasta", "patience", "permission",
        "physics", "poetry", "pollution", "poverty", "power", "pronunciation",
        "psychology", "publicity", "quartz", "racism", "rain", "relaxation",
        "reliability", "research", "respect", "revenge", "rice", "rubbish",
        "rum", "salad", "satire", "seaside", "shame", "shopping", "silence",
        "sleep", "smoke", "smoking", "snow", "soap", "software", "soil",
        "sorrow", "soup", "speed", "spelling", "steam", "stuff", "stupidity",
        "sunshine", "symmetry", "tennis", "thirst", "thunder", "toast",
        "tolerance", "toys", "traffic", "transporation", "travel", "trust", "understanding",
        "unemployment", "unity", "validity", "veal", "vengeance", "violence"
    )

    private var rules: ArrayList<Rule> = arrayListOf()

    init {
        add("(.+)$", "$1s")
        add("(.+)s$", "$1ses")
        add("(t|r|l|b)y$", "$1ies")
        add("(.+)x$", "$1xes")
        add("(sh|zz|ss)$", "$1es")
        add("(ax)is",  "$1es")
        add("(cact|nucle|alumn|bacill|fung|radi|stimul|syllab)us$", "$1i")
        add("(corp)us$", "$1ora")
        add("(.+)sis$", "$1ses")
        add("(.+)ch$", "$1ches")
        add("(.+)o$", "$1os")
        add("(buffal|carg|mosquit|torped|zer|vet|her|ech)o$", "$1oes")
        add("(.+)fe$", "$1ves")
        add("(thie)f$", "$1ves")
        add("(.+)oaf$", "$1oaves")
        add("(.+)um$", "$1a")
        add("(.+)ium$", "$1ia")
        add("(.+)oof$", "$1ooves")
        add("(nebul)a", "$1ae")
        add("(criteri|phenomen)on$", "$1a")
        add("(potat|tomat|volcan)o$", "$1oes")
        add("^(|wo|work|fire)man$",  "$1men")
        add("(f)oot$",  "$1eet")
        add("(.+)lf$",  "$1lves")
        add("(t)ooth$",  "$1eeth")
        add("(g)oose$",  "$1eese")
        add("^(c)hild$",  "$1hildren")
        add("^(o)x$",  "$1xen")
        add("^(p)erson$",  "$1eople")
        add("(m|l)ouse$",  "$1ice")
        add("^(d)ie$",  "$1ice")
        add("^(alg|vertebr|vit)a$",  "$1ae")
        add("^(a)lumna$",  "$1lumnae")
        add("^(a)pparatus$",  "$1pparatuses")
        add("^(ind)ex$",  "$1ices")
        add("^(append|matr)ix$",  "$1ices")
        add("^(b|tabl)eau$",  "$1eaux")
        add("(.+)arf$",  "$1arves")
        add("(embarg)o$",  "$1oes")
        add("(gen)us$",  "$1era")
        add("(r)oof$",  "$1oofs")
        add("(l)eaf$",  "$1eaves")
        add("(millen)ium$",  "$1ia")
        add("(th)at$",  "$1ose")
        add("(th)is$",  "$1ese")

        unchanging("sheep")
        unchanging("deer")
        unchanging("moose")
        unchanging("swine")
        unchanging("bison")
        unchanging("corps")
        unchanging("means")
        unchanging("series")
        unchanging("scissors")
        unchanging("species")
    }

    private fun add(rule: String, template: String) {
        rules.add(0, Rule(rule, template))
    }

    private fun uncountable(word: String) {
        uncountables.add(0, word.lowercase())
    }

    private fun unchanging(word: String) {
        uncountables.add(0, word.lowercase())
    }

    data class Rule(val rule: String, val template: String)

    companion object {
        var sharedInstance: Pluralize = Pluralize()

        fun apply(word: String): String {
            if (sharedInstance.uncountables.contains(word.lowercase()) || word.isEmpty()) {
                return word
            }

            sharedInstance.rules.forEach { pair ->
                val newValue = regexReplace(word, pair.rule, pair.template)

                if (newValue != word) {
                    return newValue
                }
            }

            return word
        }

        fun add(rule: String, template: String) {
            sharedInstance.add(rule, template)
        }

        fun uncountable(word: String) {
            sharedInstance.uncountable(word)
        }

        fun unchanging(word: String) {
            sharedInstance.unchanging(word)
        }

        private fun regexReplace(input: String, pattern: String, template: String): String {
            return input.replace(pattern.toRegex(RegexOption.IGNORE_CASE), template)
        }
    }
}

fun String.pluralize(count: Int = 2, with: String = ""): String {
    if (count == 1) {
        return this
    }

    if (with.isEmpty()) {
        return Pluralize.apply(this)
    }

    return with
}
