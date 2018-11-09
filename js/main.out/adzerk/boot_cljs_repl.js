// Compiled by ClojureScript 1.10.439 {}
goog.provide('adzerk.boot_cljs_repl');
goog.require('cljs.core');
goog.require('weasel.repl');
var repl_conn_3339 = null;
if(cljs.core.truth_((function (){var and__4036__auto__ = repl_conn_3339;
if(cljs.core.truth_(and__4036__auto__)){
return (!(weasel.repl.alive_QMARK_.call(null)));
} else {
return and__4036__auto__;
}
})())){
weasel.repl.connect.call(null,null,new cljs.core.Keyword(null,"print","print",1299562414),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"repl","repl",-35398667),null,new cljs.core.Keyword(null,"console","console",1228072057),null], null), null));
} else {
}

//# sourceMappingURL=boot_cljs_repl.js.map
