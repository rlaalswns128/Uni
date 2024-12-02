# HEALTH SUPPLEMENTS

건강기능식품 데이터 분석 프로젝트

---

## 📋 프로젝트 개요

**건강기능식품 데이터 분석 프로젝트**는 Python을 활용하여 건강기능식품 데이터를 수집, 정제, 분석 및 시각화하는 프로젝트입니다.  
생산 및 수입 데이터를 다루며, 시계열 분석 모델(ARIMA, LSTM)을 사용하여 미래 추세를 예측합니다.

---

## 📊 주요 내용

- **공공 건강 데이터 포털 API**를 활용한 데이터 수집
- 데이터셋 병합 및 전처리로 심층 분석 수행
- 다양한 차트와 그래프를 활용한 데이터 시각화
- **ARIMA**와 **LSTM 모델**을 통한 생산 및 수입량 추세 예측

---

## 🛠️ 코드 분석

### 1. 데이터 수집
공공 API를 호출하여 데이터를 수집하고 CSV로 저장:
```python
response = requests.get(base_url, params=params, verify=False)
all_data.extend(response.json()["body"]["items"])
```

### 2.	데이터 전처리
문자열에서 불필요한 문자와 숫자를 제거하고 정제된 데이터 생성:
```python
def remove_patterns(text, patterns):
    for pattern in patterns:
        text = re.sub(pattern, "", text)
    return text.strip()
```

### 3.	시각화
데이터의 주요 트렌드를 시각화하여 사용자에게 정보를 직관적으로 전달:
```python
plt.pie(category_totals, labels=category_totals.index, autopct='%1.1f%%')
```

### 4. 미래 예측
ARIMA 및 LSTM 모델을 사용하여 생산 및 수입량의 미래 데이터를 예측:
```python
model = ARIMA(data_series, order=(1, 1, 1))
forecast = model.fit().forecast(steps=5)
```
---

## 📈 결론

	•	주요 패턴 발견:
	•	특정 품목과 업체에서 생산 및 수입량이 집중됨.
	•	연도별 데이터에서 수입량 증가 추세가 관찰됨.
	•	예측 결과:
	•	ARIMA 모델은 안정적 추세 예측에 유용하며, LSTM은 변동성이 높은 데이터에 적합함.
	•	활용 가능성:
	•	이 프로젝트는 건강기능식품 시장의 생산 및 수입량을 예측하여 시장 분석 및 의사결정에 기여할 수 있음.
---

## 💡 개선사항

	1.	데이터 품질 향상
		•	결측값 처리 방식을 고도화하고 중복 데이터를 정제하여 데이터 신뢰성 강화.
		•	제품명 및 품목 데이터 정제를 통해 분석 품질 향상.
	2.	분석 및 모델 개선
		•	SARIMA, Prophet 등 다양한 모델 도입으로 예측 정확도 비교.
		•	하이퍼파라미터 튜닝과 추가 평가 지표 도입으로 모델 성능 강화.
---

## 🧑‍💻 기술 스택

	•	언어: Python
	•	라이브러리: Pandas, Matplotlib, Seaborn, WordCloud, TensorFlow
	•	모델: ARIMA, LSTM
---

## 📌 앞으로의 확장성

	•	데이터의 품질을 높이기 위한 추가 정제 작업.
	•	더 많은 외부 데이터를 활용한 모델 성능 향상.
	•	Flask와 Django를 활용한 웹 대시보드 제작.
