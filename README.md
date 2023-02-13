IDE的UML插件坏了,没搞好下面是类关系

IReportService{registerObserver(),removeObserver(), notifyObservers()} -> ReportService{weatherData,observers}
IObserver{update(), display()} -> Station1{reportService}
........
IObserver{update(), display()} -> StationN{reportService}