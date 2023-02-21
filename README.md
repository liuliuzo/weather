观察者模式实现气报站

IDE的UML插件坏了没搞好, 下面是类关系

IReportService{registerObserver(),removeObserver(), notifyObservers()} -> ReportService{weatherData,observers}

IObserver{update(), display()} -> Station1{reportService}
........
IObserver{update(), display()} -> StationN{reportService}
