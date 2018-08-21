
## FragmentSample

## FragmentStatePagerAdapter与FragmentPagerAdapter的区别
1、从"State"的字样的可以看出来，FragmentStatePagerAdapter是会把不必要的显示的Fragment的完全销毁，
即调用remove(),但是数据会被储存在 saveInstanceState，下次调用时是可根据的其数据进行恢复。

2、而FragmentPagerAdapter的Fragment在不必要显示时，只会销毁该Fragment的视图，但是会保存实例，
即调用dedath()，下次调用时只需创建Fragment的视图即可。

## 参考文献
1、[FragmentStatePagerAdapter与FragmentPagerAdapter的区别](https://blog.csdn.net/jianyucsdn/article/details/52824901)
2、[]()
