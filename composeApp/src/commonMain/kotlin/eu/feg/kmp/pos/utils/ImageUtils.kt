package eu.feg.kmp.pos.utils

fun getIconPath(iconFileName: String?, prefix: String? = ""): String {
    return "https://cdn-cf.ifortuna.cz/" + if (prefix.isNullOrEmpty()) "128/$iconFileName" else "$prefix/128/$iconFileName"
}
