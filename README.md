
## FragmentSample
值得注意的是：如果你喜欢使用Fragment，一定要清楚这些方法，哪个会销毁视图，
哪个会销毁实例，哪个仅仅只是隐藏，这样才能更好的使用它们。

a、比如：我在FragmentA中的EditText填了一些数据，当切换到FragmentB时，
如果希望会到A还能看到数据，则适合你的就是hide和show；也就是说，希望保留用户操作的面板，
你可以使用hide和show，当然了不要使劲在那new实例，进行下非null判断。

b、再比如：我不希望保留用户操作，你可以使用remove()，然后add()；
或者使用replace()这个和remove,add是相同的效果。

c、remove和detach有一点细微的区别，在不考虑回退栈的情况下，remove会销毁整个Fragment实例，
而detach则只是销毁其视图结构，实例并不会被销毁。那么二者怎么取舍使用呢？
如果你的当前Activity一直存在，那么在不希望保留用户操作的时候，你可以优先使用detach。


## FragmentStatePagerAdapter与FragmentPagerAdapter的区别
1、从"State"的字样的可以看出来，FragmentStatePagerAdapter是会把不必要的显示的Fragment的完全销毁，
即调用remove(),但是数据会被储存在 saveInstanceState，下次调用时是可根据的其数据进行恢复。

2、而FragmentPagerAdapter的Fragment在不必要显示时，只会销毁该Fragment的视图，但是会保存实例，
即调用dedath()，下次调用时只需创建Fragment的视图即可。

## 参考文献
1、[FragmentStatePagerAdapter与FragmentPagerAdapter的区别](https://blog.csdn.net/jianyucsdn/article/details/52824901)
2、[Android Fragment 真正的完全解析（上）](https://blog.csdn.net/lmj623565791/article/details/37970961)
3、[Android Fragment 真正的完全解析（下）](https://blog.csdn.net/lmj623565791/article/details/37992017)
4、[Android 官方推荐 : DialogFragment 创建对话框](https://blog.csdn.net/lmj623565791/article/details/37815413)
5、[Android 屏幕旋转 处理 AsyncTask 和 ProgressDialog 的最佳方案](https://blog.csdn.net/lmj623565791/article/details/37815413)
